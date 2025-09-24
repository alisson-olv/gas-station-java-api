package com.alisson.gas_station.infrastructure.entities;

import jakarta.persistence.*;
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

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;
}
