package com.alisson.gas_station.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Fuel name cannot be empty/null")
    private String name;

    @Column(name = "price_per_liter", nullable = false)
    @NotNull(message = "Price cannot be empty/null")
    @Positive(message = "Price must be greater than zero")
    private BigDecimal pricePerLiter;
}
