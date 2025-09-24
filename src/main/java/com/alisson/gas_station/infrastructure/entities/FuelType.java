package com.alisson.gas_station.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fuel_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_per_liter")
    private BigDecimal pricePerLiter;
}
