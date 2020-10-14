package sk.stopangin.expensemanager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(
        basePackages = {"sk.stopangin.expensemanager"},
        excludeFilters = {
                @ComponentScan.Filter(Service.class),
                @ComponentScan.Filter(Repository.class),
                @ComponentScan.Filter(Configuration.class)
        }
)
public class WebConfig {
}
