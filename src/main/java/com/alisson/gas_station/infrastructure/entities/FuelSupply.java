package com.alisson.gas_station.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fuel_supply")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supply_date")
    private LocalDate supplyDate;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "fuel_volume_liters")
    private Long fuelVolumeLiters;

    @OneToOne
    @JoinColumn(name = "fuel_pump_id")
    private FuelPump fuelPump;
}
