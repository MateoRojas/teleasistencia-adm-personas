package org.teleasistencia.adm.personas.config;

import com.querydsl.jpa.hibernate.HibernateQueryFactory;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class SessionFactoryConfig {

    @Bean
    public HibernateQueryFactory hibernateQueryFactory(LocalSessionFactoryBean sessionFactory) {

        return new HibernateQueryFactory(() -> sessionFactory.getObject().getCurrentSession());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("org.teleasistencia.adm.personas.modelo");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/teleasistencia-adm?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {

        return new HibernateTransactionManager(sessionFactory.getObject());
    }

    public final Properties hibernateProperties() {

        Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        return hibernateProperties;
    }
}
