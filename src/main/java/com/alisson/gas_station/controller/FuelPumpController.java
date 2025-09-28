package com.alisson.gas_station.controller;

import com.alisson.gas_station.infrastructure.entities.FuelPump;
import com.alisson.gas_station.service.FuelPumpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuel-pump")
public class FuelPumpController {

    private final FuelPumpService fuelPumpService;

    @PostMapping
    public ResponseEntity<Void> createFuelPump(@RequestBody @Valid FuelPump fuelPump) {
        fuelPumpService.create(fuelPump);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FuelPump>> getFuelPumps() {
        List<FuelPump> fuelPumps = fuelPumpService.getFuelPumps();

        return ResponseEntity.ok(fuelPumps);
    }
}
