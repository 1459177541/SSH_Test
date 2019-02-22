package config;

import org.springframework.context.annotation.*;
import service.ServiceConfig;

@Configuration
@ComponentScan("controller")
@PropertySource({"classpath:dataSource.properties"})
@Import(ServiceConfig.class)
public class ContextConfig{


}
