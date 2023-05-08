package com.galaxy.pinwheel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
        "com.galaxy.pinwheel.*"
})
public class PinwheelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinwheelApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
