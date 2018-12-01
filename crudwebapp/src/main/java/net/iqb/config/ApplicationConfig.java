
package net.iqb.config;

import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author gershom
 */
@Configuration
@ComponentScan(basePackages = {"net.iqb"})
@Import(DataSourceConfig.class)
public class ApplicationConfig {
    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurerI()
    {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PreferencesPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertyPlaceholderConfigurer;
    }
    
}
