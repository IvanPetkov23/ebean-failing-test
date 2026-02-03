package com.example;

import io.ebean.Database;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.ConfigValue;

import java.util.Properties;

@ApplicationScoped
public class DbConfig {

    @Produces
    public Database initDb() {
        final Properties properties = getProperties();
        return Database.builder()
                .loadFromProperties(properties)
                .build();
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        ConfigProvider.getConfig().getPropertyNames().forEach(key -> {
            if (key.startsWith("ebean.") || key.startsWith("datasource.")) {
                final ConfigValue configValue = ConfigProvider.getConfig().getConfigValue(key);
                properties.setProperty(key, configValue.getRawValue());
            }
        });

        return properties;
    }
}
