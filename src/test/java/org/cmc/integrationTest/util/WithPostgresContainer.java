package org.cmc.integrationTest.util;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(initializers = PostgresContextInitializer.class)
@ActiveProfiles(resolver = PostgresActiveProfilesResolver.class)
public @interface WithPostgresContainer { }