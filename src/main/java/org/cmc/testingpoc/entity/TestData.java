package org.cmc.testingpoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="test")
public class TestData {
    @Id
    public UUID id;
    public String details;
}
