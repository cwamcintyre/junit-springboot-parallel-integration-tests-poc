package org.cmc.integrationTest;

import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.TestDataFactory;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@WithPostgresContainer
public class RunThatInParallelTest extends BaseIntegrationTest {

    @Test
    void GivenListOfData_whenCountCalled_returnsTenRecords() {
        // given
        List<TestData> listOfTen = TestDataFactory.createMultiple(10);
        testRepository.saveAll(listOfTen);

        // when
        long count = testRepository.count();

        // then
        assertEquals(10, count);
    }
}
