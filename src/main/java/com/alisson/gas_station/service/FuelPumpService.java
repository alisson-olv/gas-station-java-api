package com.alisson.gas_station.service;

import com.alisson.gas_station.infrastructure.entities.FuelPump;
import com.alisson.gas_station.infrastructure.repositories.FuelPumpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelPumpService {

    private final FuelPumpRepository fuelPumpRepository;

    public void create(FuelPump fuelPump) {
        fuelPumpRepository.save(fuelPump);
    }

    public FuelPump searchFuelPumpById(Integer id) {
        return fuelPumpRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("Fuel Pump not found by id" + id));
    }

    @Transactional
    public void deleteFuelPumpById(Integer id) {
        fuelPumpRepository.deleteById(id);
    }

    /* todo: validate the data before update the database */

    public void updateFuelPump(Integer id, FuelPump fuelPump) {
        FuelPump pump = searchFuelPumpById(id);
        fuelPump.setId(pump.getId());

        fuelPumpRepository.save(fuelPump);
    }
}
