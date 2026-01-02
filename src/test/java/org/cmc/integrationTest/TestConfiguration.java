package org.cmc.integrationTest;

import org.cmc.integrationTest.util.factory.CustomerFactory;
import org.cmc.testingpoc.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public CustomerFactory customerFactory(CustomerRepository repository) {
        return new CustomerFactory(repository);
    }
}
