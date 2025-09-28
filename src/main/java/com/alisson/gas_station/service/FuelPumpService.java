package com.alisson.gas_station.service;

import com.alisson.gas_station.infrastructure.entities.FuelPump;
import com.alisson.gas_station.infrastructure.entities.FuelType;
import com.alisson.gas_station.infrastructure.repositories.FuelPumpRepository;
import com.alisson.gas_station.infrastructure.repositories.FuelTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FuelPumpService {

    private final FuelPumpRepository fuelPumpRepository;
    private final FuelTypeRepository fuelTypeRepository;

    public void create(FuelPump fuelPump) {
        Integer fuelTypeId = fuelPump.getFuelType().getId();
        FuelType fuelType = fuelTypeRepository.findById(fuelTypeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Type Id is not found, Id: " + fuelTypeId)
        );

        fuelPump.setFuelType(fuelType);

        fuelPumpRepository.save(fuelPump);
    }

    public FuelPump searchFuelPumpById(Integer id) {
        return fuelPumpRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Pump not found. Id: " + id)
        );
    }

    public void deleteFuelPumpById(Integer id) {
        fuelPumpRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Pump not found. Id: " + id)
        );
        fuelPumpRepository.deleteById(id);
    }

    public List<FuelPump> getFuelPumps() {
        return fuelPumpRepository.findAll();
    }

    public void updateFuelPump(Integer id, FuelPump fuelPump) {
        FuelPump existingPump = searchFuelPumpById(id);

        Integer fuelTypeId = fuelPump.getFuelType().getId();
        FuelType fuelType = fuelTypeRepository.findById(fuelTypeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Type Id is not found, Id: " + fuelTypeId)
        );

        existingPump.setName(fuelPump.getName());
        existingPump.setFuelType(fuelType);

        fuelPumpRepository.save(existingPump);
    }
}
