package org.cmc.testingpoc.repository;

import java.util.UUID;

import org.cmc.testingpoc.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}



