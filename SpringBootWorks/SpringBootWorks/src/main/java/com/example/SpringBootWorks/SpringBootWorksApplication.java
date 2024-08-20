package com.example.SpringBootWorks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties("profile")
@SpringBootApplication
public class SpringBootWorksApplication {

    private boolean dev;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWorksApplication.class, args);
    }

    public void setDev(boolean dev) {
        this.dev = dev;
    }

    @Bean
    public SystemProfile setProfile() {
        if (dev) {
            return new DevProfile();
        } else {
            return new ProductionProfile();
        }
    }
}
