package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"aop","dao","entity","service"})
@PropertySource({"classpath:jdbc.properties"})
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement
public class ContextConfig{

    private final Environment environment;

    @Autowired
    public ContextConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("jdbc.driverClass"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("entity");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ssh");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
