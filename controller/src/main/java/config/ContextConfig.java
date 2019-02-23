package config;

import org.springframework.context.annotation.*;
import service.ServiceConfig;

@Configuration
@ComponentScan("controller")
@Import(ServiceConfig.class)
public class ContextConfig{


}
