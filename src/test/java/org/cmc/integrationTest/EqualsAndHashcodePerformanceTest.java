package org.cmc.integrationTest;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.cmc.integrationTest.util.BaseIntegrationTest;
import org.cmc.integrationTest.util.WithPostgresContainer;
import org.cmc.testingpoc.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.Rule;

import java.util.List;

@WithPostgresContainer
public class EqualsAndHashcodePerformanceTest extends BaseIntegrationTest {

    @Rule
    public BenchmarkRule benchmark = new BenchmarkRule();

    @Test
    @BenchmarkOptions()
    public void testLazyEqualsAndHashcodePerformance() {
        List<Customer> customers = customerFactory.createAndPersistMultiple(1000);

    }
}
