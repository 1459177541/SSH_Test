package config;

import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(ContextConfig.class)
public class SpringMvcConfig implements WebMvcConfigurer {

}
