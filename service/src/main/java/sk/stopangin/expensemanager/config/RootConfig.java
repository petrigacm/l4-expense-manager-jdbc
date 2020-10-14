package sk.stopangin.expensemanager.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(
        basePackages = {"sk.stopangin.expensemanager"},
        excludeFilters = {
                @ComponentScan.Filter(Controller.class),
                @ComponentScan.Filter(RestController.class),
                @ComponentScan.Filter(value = WebConfig.class, type = FilterType.ASSIGNABLE_TYPE)
        }
)
public class RootConfig {
}
