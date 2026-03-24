package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjections {

    @Bean("dirToSearch")
    public String dirToSearch() {

        return "src/main/java/org/example";
    }
}

// System System System