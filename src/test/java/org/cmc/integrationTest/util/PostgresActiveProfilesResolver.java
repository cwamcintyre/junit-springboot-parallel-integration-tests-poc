package org.cmc.integrationTest.util;

import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.test.context.support.DefaultActiveProfilesResolver;

public class PostgresActiveProfilesResolver extends DefaultActiveProfilesResolver {
    @Override
    public String[] resolve(Class<?> testClass) {
        return Stream.concat(
                        Stream.of(String.valueOf(testClass.getName().hashCode())),
                        Arrays.stream(super.resolve(testClass)))
                .toArray(String[]::new);
    }
}
