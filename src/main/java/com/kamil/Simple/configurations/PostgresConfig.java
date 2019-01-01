package com.kamil.Simple.configurations;

import com.kamil.Simple.food.Food;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "psEntityManagerFactory", transactionManagerRef = "postgresTransactionManager",
        basePackageClasses = {Food.class})
public class PostgresConfig {

    @Bean
    @ConfigurationProperties("ps.datasource")
    public DataSource psDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "psEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean psEntityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("psDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages(Food.class).persistenceUnit("postgresql").build();
    }

    @Bean("postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("psEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
