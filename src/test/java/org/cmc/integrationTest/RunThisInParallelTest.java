package org.cmc.integrationTest;

import jakarta.transaction.Transactional;
import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WithPostgresContainer
public class RunThisInParallelTest extends BaseIntegrationTest {

    @Test
    @Transactional
    void GivenListOfData_whenCountCalled_returnsFiveRecords() {
        // given
        List<Customer> listOfFive = customerFactory.createAndPersistMultiple(5);

        // when
        long count = customerRepository.count();

        // then
        assertEquals(5, count);
    }
}
