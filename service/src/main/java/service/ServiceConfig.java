package service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(dao.DaoConfig.class)
@ComponentScan({"service", "entity.dto"})
public class ServiceConfig {

}
