package com.example.springboot3.mutidatasource;

import com.example.springboot3.entity.company.Company;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.mutidatasource
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:13
 * @Description: TODO
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.example.springboot3.repository.company",
        entityManagerFactoryRef = "localEntityManagerFactory",
        transactionManagerRef = "localTransactionManager")
public class LocalhostDataSource {

    /**
     * Here it will get url, username, password and driver-class-name
     * which we have defined in application properties file for company.
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.local")
    public DataSourceProperties companyDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Create the datasource using companyDataSourceProperties
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.local.configuration")
    public DataSource companyDataSource() {
        return companyDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    /**
     * EntityManager will find Entity classes inside this company package
     * (i.e com.techgeeknext.entities.company.Company).
     * @param builder
     * @return
     */
    @Bean(name = "localEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean companyEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(companyDataSource())
                .packages(Company.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager localTransactionManager(
            final @Qualifier("localEntityManagerFactory") LocalContainerEntityManagerFactoryBean companyEntityManagerFactory) {
        return new JpaTransactionManager(companyEntityManagerFactory.getObject());
    }
}
