package com.alisson.gas_station.controller;

import com.alisson.gas_station.infrastructure.entities.FuelType;
import com.alisson.gas_station.service.FuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuel-type")
public class FuelTypeController {

    private final FuelTypeService fuelTypeService;

    @PostMapping
    public ResponseEntity<FuelType> createFuelType(@RequestBody FuelType fuelType) {
        FuelType createdFuelType = fuelTypeService.createFuelType(fuelType);

        URI location = URI.create("/fuel-type/" + createdFuelType.getId());

        return ResponseEntity.created(location).body(createdFuelType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelType> findFuelTypeById(@PathVariable("id") Integer id) {
        FuelType fuelTypeInfo = fuelTypeService.findFuelTypeById(id);

        return ResponseEntity.ok(fuelTypeInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelTypeById(@PathVariable("id") Integer id) {
        fuelTypeService.deleteFuelTypeById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FuelType>> getFuelTypes() {
        List<FuelType> fuelTypeList = fuelTypeService.getFuelTypes();

        return ResponseEntity.ok(fuelTypeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFuelTypeById(@PathVariable("id") Integer id, @RequestBody FuelType fuelType) {
        fuelTypeService.updateFuelType(id, fuelType);

        return ResponseEntity.noContent().build();
    }
}
