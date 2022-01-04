package HW_4.Java_Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    PlusServiceJava plusServiceJava() {
        return new PlusServiceJava();
    }

    @Bean
    MinusServiceJava minusServiceJava() {
        return new MinusServiceJava();
    }
}
