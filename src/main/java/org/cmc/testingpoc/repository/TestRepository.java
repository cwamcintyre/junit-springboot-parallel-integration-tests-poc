package org.cmc.testingpoc.repository;

import org.cmc.testingpoc.entity.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<TestData, UUID> {
}
