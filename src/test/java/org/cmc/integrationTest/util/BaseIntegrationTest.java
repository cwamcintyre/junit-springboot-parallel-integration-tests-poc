package org.cmc.integrationTest.util;

import org.cmc.testingpoc.Application;
import org.cmc.testingpoc.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes= Application.class)
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseIntegrationTest {

    @Autowired
    protected TestRepository testRepository;

    @BeforeEach
    void beforeEach() {
        testRepository.deleteAll();
    }
}
