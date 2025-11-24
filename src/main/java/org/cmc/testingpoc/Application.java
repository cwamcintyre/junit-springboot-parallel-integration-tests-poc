package org.cmc.testingpoc;

import org.cmc.testingpoc.entity.TestData;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        TestData td = TestData.builder()
                .id(UUID.randomUUID())
                .details("hello")
                .build();

        System.out.println(td);
    }
}
