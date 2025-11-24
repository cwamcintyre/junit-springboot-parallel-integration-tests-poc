package org.cmc.integrationTest;

import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.TestDataFactory;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.TestData;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WithPostgresContainer
public class RunThisInParallelTest extends BaseIntegrationTest {

    @Test
    void GivenListOfData_whenCountCalled_returnsFiveRecords() {
        // given
        List<TestData> listOfFive = TestDataFactory.createMultiple(5);
        testRepository.saveAll(listOfFive);

        // when
        long count = testRepository.count();

        // then
        assertEquals(5, count);
    }
}
