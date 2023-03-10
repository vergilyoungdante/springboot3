package com.example.springboot3.mutidatasource;

import com.example.springboot3.entity.employee.Employee;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.mutidatasource
 * @Author: vergil young
 * @CreateTime: 2023-01-05  19:28
 * @Description: TODO
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.springboot3.repository.employee",
        entityManagerFactoryRef = "remoteEntityManagerFactory",
        transactionManagerRef= "remoteTransactionManager")
public class remoteDataSource {

    /**
     * Here it will get url, username, password and driver-class-name
     * which we have defined in application properties file for employee.
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.remote")
    public DataSourceProperties employeeDatasourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Create the datasource using employeeDatasourceProperties
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.remote.configuration")
    public DataSource employeeDataSource() {
        return employeeDatasourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    /**
     * EntityManager will find Entity classes inside this company package
     * (i.e com.techgeeknext.entities.employee.Employee).
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "remoteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(employeeDataSource())
                // for specifying package .packages("com.techgeeknext.entities.employee.type")
                .packages(Employee.class)
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager remoteTransactionManager(
            final @Qualifier("remoteEntityManagerFactory") LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory) {
        return new JpaTransactionManager(employeeEntityManagerFactory.getObject());
    }
}
