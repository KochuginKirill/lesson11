package ru.gb.aspect.recovery;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.recovery")
public class RecoveryProperties {

    private boolean enabled = false;

    public boolean isEnabled() {
        return this.enabled;
    }
}