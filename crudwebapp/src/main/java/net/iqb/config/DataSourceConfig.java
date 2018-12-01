
package net.iqb.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author gershom
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
    
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${hibernate.enable_lazy_load_no_trans}")
    private String hibernateEnableLazyloadnotrans;
    
    @Bean
    public Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",hibernateDialect);
        properties.put("hibernate.show_sql",hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto",hibernateHbm2ddlAuto);
        properties.put("hibernate.enable_lazy_load_no_trans", hibernateEnableLazyloadnotrans);
        return properties;
    }
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(DataSourceUtility.getDataSource());
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        localSessionFactoryBean.setPackagesToScan(new String[]{"net.iqb.model"});
        return localSessionFactoryBean ;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate geHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }
}
