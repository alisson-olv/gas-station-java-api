package com.alisson.gas_station.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "fuel_pump")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelPump {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Fuel Pump name cannot be null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    @NotNull(message = "Fuel Type Id in Fuel Pump cannot be null")
    private FuelType fuelType;
}
