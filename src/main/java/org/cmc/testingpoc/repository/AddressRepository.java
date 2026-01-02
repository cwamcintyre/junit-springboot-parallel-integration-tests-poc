package org.cmc.testingpoc.repository;

import org.cmc.testingpoc.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    Optional<Address> findByStreetAndCityAndStateAndPostalCodeAndCountry(String street, String city, String state, String postalCode, String country);
}

