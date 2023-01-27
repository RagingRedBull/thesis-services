package dev.prmts.ui.backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dev.prmts.common"})
@EntityScan(basePackages = {"dev.prmts.common"})
@ComponentScan(basePackages = {"dev.prmts.common"})
public class UiBackendConfig {
}
