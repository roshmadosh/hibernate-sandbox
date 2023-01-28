package link.hiroshisprojects.hibernate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({ "link.hiroshisprojects.hibernate.models.item", "link.hiroshisprojects.hibernate.models.order" })
public class WebMvcConfig {

}
