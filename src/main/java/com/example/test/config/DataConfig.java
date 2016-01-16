package com.example.test.config;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Anup on 9/9/15.
 */

@Configuration
@EnableJpaRepositories("com.example.test.repository")
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test_db");
        ds.setUsername("root");
        ds.setPassword("anup");
        return ds;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){ //the method name should be entityManagerFactory as spring by-default looks for it if used other spring throws exception

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(Boolean.TRUE);
        vendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.example.test.entity");

        //factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        Properties jpaProperties = new Properties();
        //jpaProperties.put("hibernate.hbm2ddl.auto","update");
        jpaProperties.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy"); //TODO: check alternative for NamingStrategy in Hibernate 5
        jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");

        factory.setJpaProperties(jpaProperties);
        // TODO: following setter is needed if persistence.xml is present and hibernate properties are set via xml
       /* factory.setPersistenceXmlLocation("classpath:persistence.xml");
        factory.setPersistenceUnitName("hibernatePersistenceUnit");
        factory.afterPropertiesSet();*/
        return factory;
    }

    @Bean
    public SharedEntityManagerBean entityManager() {
        SharedEntityManagerBean entityManager = new SharedEntityManagerBean();
        entityManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return entityManager;
    }

    /*@Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }*/

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public ImprovedNamingStrategy namingStrategy(){
        return new ImprovedNamingStrategy();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
