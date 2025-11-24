package org.cmc.integrationTest;

import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.TestDataFactory;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.TestData;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WithPostgresContainer
public class RunTheseTests extends BaseIntegrationTest {

    @Nested
    public class These {
        @Test
        void GivenListOfData_whenCountCalled_returnsRecords() {
            // given
            List<TestData> listOf = TestDataFactory.createMultiple(4);
            testRepository.saveAll(listOf);

            // when
            long count = testRepository.count();

            // then
            assertEquals(4, count);
        }
    }

    @Nested
    public class AndThese {
        @Test
        void GivenListOfData_whenCountCalled_returnsRecords() {
            // given
            List<TestData> listOf = TestDataFactory.createMultiple(12);
            testRepository.saveAll(listOf);

            // when
            long count = testRepository.count();

            // then
            assertEquals(12, count);
        }
    }
}
