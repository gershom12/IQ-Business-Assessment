
package net.iqb.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

/**
 *
 * @author gershom
 */
public class DataSourceUtility {
    
    /*This method is used to create Data source*/
    public static DataSource getDataSource()
    {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(5);
        dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        dataSource.addDataSourceProperty("url", "jdbc:postgresql://localhost:5432/empdb");
        dataSource.addDataSourceProperty("user","dev");
        dataSource.addDataSourceProperty("password", "dev");
        return dataSource;
    }
}
