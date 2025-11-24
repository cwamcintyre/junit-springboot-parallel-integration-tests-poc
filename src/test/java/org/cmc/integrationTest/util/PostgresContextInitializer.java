package org.cmc.integrationTest.util;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostgresContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // Generate a unique database name per test class
        String dbName = "testdb_" + UUID.randomUUID();

        var container = PostgresContainerHelper.getContainer();

        // Create database inside the static container
        String uniqueDb = "testdb_" + UUID.randomUUID().toString().replace("-", "_");
        try (Connection conn = DriverManager.getConnection(
                container.getJdbcUrl(), container.getUsername(), container.getPassword());
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE " + uniqueDb + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Inject Spring properties
        Map<String, Object> props = new HashMap<>();
        props.put("spring.datasource.url",
                container.getJdbcUrl().replace(
                        container.getDatabaseName(), uniqueDb
                ));
        props.put("spring.datasource.username",
                container.getUsername());
        props.put("spring.datasource.password",
                container.getPassword());

        MutablePropertySources sources = applicationContext.getEnvironment().getPropertySources();
        sources.addFirst(new MapPropertySource("dynamicPostgresProps", props));
    }
}
