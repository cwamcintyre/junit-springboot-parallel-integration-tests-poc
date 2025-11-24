package org.cmc.integrationTest.util;

import org.cmc.testingpoc.entity.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDataFactory {
    public static TestData create() {
        return TestData.builder()
                .id(UUID.randomUUID())
                .details("created by TestDataFactory")
                .build();
    }

    public static List<TestData> createMultiple(int number) {
        ArrayList<TestData> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(create());
        }

        return list;
    }
}
