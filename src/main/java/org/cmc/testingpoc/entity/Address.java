package org.cmc.testingpoc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "address",
       uniqueConstraints = @UniqueConstraint(name = "uk_address_natural",
               columnNames = {"street", "city", "state", "postal_code", "country"}))
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @EqualsAndHashCode.Include
    @Column(name = "street", length = 200, nullable = false)
    private String street;

    @EqualsAndHashCode.Include
    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @EqualsAndHashCode.Include
    @Column(name = "state", length = 100)
    private String state;

    @EqualsAndHashCode.Include
    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @EqualsAndHashCode.Include
    @Column(name = "country", length = 100, nullable = false)
    private String country;
}
