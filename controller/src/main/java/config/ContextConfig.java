package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("controller")
@Import(ServiceConfig.class)
public class ContextConfig{


}
