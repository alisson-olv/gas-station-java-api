package com.alisson.gas_station.infrastructure.repositories;

import com.alisson.gas_station.infrastructure.entities.FuelPump;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelPumpRepository extends JpaRepository<FuelPump, Integer> {
}