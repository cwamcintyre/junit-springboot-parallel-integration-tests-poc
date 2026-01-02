package org.cmc.testingpoc.service;

import org.cmc.testingpoc.entity.Address;
import org.cmc.testingpoc.entity.Customer;
import org.cmc.testingpoc.repository.AddressRepository;
import org.cmc.testingpoc.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        Address addr = customer.getAddress();
        if (addr != null) {
            Optional<Address> found = addressRepository.findByStreetAndCityAndStateAndPostalCodeAndCountry(
                    addr.getStreet(), addr.getCity(), addr.getState(), addr.getPostalCode(), addr.getCountry());
            found.ifPresent(customer::setAddress);
            // if not found, cascade from customer will persist the new address because of CascadeType.PERSIST
        }
        return customerRepository.save(customer);
    }
}

