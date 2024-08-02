package ru.gb.aspect.recovery;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RecoveryProperties.class)
@ConditionalOnProperty(value = "application.recovery.enabled", havingValue = "true")
public class RecoveryAutoConfiguration {

    @Bean
    public RecoveryAspect recoveryAspect(RecoveryProperties properties) {
        return new RecoveryAspect(properties);
    }

}
