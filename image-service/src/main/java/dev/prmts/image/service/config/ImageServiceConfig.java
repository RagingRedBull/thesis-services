package dev.prmts.image.service.config;

import org.apache.tika.Tika;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceConfig {
    @Bean
    public Tika tikaParser() {
        return new Tika();
    }
}
