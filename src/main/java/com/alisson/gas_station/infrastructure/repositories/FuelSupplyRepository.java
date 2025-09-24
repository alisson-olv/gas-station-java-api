package com.alisson.gas_station.infrastructure.repositories;

import com.alisson.gas_station.infrastructure.entities.FuelSupply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelSupplyRepository extends JpaRepository<FuelSupply, Integer> {
}