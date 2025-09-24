package com.alisson.gas_station.infrastructure.repositories;

import com.alisson.gas_station.infrastructure.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType, Integer> {
}