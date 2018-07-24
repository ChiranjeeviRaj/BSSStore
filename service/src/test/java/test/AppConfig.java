package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"uk.bss.store.service", "uk.bss.store.entity.manager"})
public class AppConfig {
}
