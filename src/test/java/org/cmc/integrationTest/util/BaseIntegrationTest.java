package org.cmc.integrationTest.util;

import org.cmc.integrationTest.TestConfiguration;
import org.cmc.integrationTest.util.factory.CustomerFactory;
import org.cmc.testingpoc.Application;
import org.cmc.testingpoc.repository.CustomerRepository;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = { Application.class, TestConfiguration.class })
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseIntegrationTest {

    @Autowired
    protected CustomerRepository customerRepository;

    @Autowired
    protected CustomerFactory customerFactory;
}
