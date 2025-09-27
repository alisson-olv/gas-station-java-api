package com.alisson.gas_station.service;

import com.alisson.gas_station.infrastructure.entities.FuelType;
import com.alisson.gas_station.infrastructure.repositories.FuelTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    public FuelType createFuelType(FuelType fuelType) {
        return fuelTypeRepository.save(fuelType);
    }

    public FuelType findFuelTypeById(Integer id) {
        return fuelTypeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Type not found. Id: " + id));
    }

    @Transactional
    public void deleteFuelTypeById(Integer id) {
        fuelTypeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuel Type Id not found. Id: " + id)
        );

        fuelTypeRepository.deleteById(id);
    }

    public List<FuelType> getFuelTypes() {
        return fuelTypeRepository.findAll();
    }

    public void updateFuelType(Integer id, FuelType fuelType) {
        FuelType pump = findFuelTypeById(id);
        fuelType.setId(pump.getId());

        fuelTypeRepository.save(fuelType);
    }
}
