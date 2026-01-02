package org.cmc.integrationTest;

import jakarta.transaction.Transactional;
import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@WithPostgresContainer
public class RunThatInParallelTest extends BaseIntegrationTest {

    @Test
    @Transactional
    void GivenListOfData_whenCountCalled_returnsTenRecords() {
        // given
        List<Customer> listOfTen = customerFactory.createAndPersistMultiple(10);

        // when
        long count = customerRepository.count();

        // then
        assertEquals(10, count);
    }
}
