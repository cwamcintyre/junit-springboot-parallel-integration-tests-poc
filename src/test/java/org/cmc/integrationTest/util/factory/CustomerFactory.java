package org.cmc.integrationTest.util.factory;

import org.cmc.testingpoc.entity.Customer;
import org.cmc.testingpoc.repository.CustomerRepository;

import java.util.UUID;

public class CustomerFactory extends BaseFactory<
        Customer,
        Customer.CustomerBuilder,
        UUID,
        CustomerRepository> {

    public CustomerFactory(CustomerRepository repository) {
        super(repository, Customer::toBuilder, Customer.CustomerBuilder::build);
    }

    @Override
    public Customer create() {
        return Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
    }
}
