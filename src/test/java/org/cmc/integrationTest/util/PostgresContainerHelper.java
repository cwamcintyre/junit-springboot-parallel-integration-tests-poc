package org.cmc.integrationTest.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainerHelper {
    private static final PostgreSQLContainer<?> container =
            new PostgreSQLContainer<>("postgres:15.5");

    static {
        container.start();
    }

    public static PostgreSQLContainer<?> getContainer() {
        return container;
    }
}
