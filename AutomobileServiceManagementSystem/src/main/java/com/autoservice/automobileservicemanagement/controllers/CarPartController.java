package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.services.CarPartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carParts")
@RequiredArgsConstructor
@Tag(name = "Car Part Management", description = "APIs for managing car parts")
public class CarPartController {

    private final CarPartService carPartService;

    @Operation(summary = "Get all car parts", description = "Retrieve a list of all car parts")
    @GetMapping
    public ResponseEntity<List<CarPartDto>> getAll() {
        List<CarPartDto> carPartDto = carPartService.getAllCarParts();
        return ResponseEntity.ok(carPartDto);
    }

    @Operation(summary = "Get a car part by ID", description = "Retrieve a car part's details using its ID")
    @GetMapping("/{id}")
    public ResponseEntity<CarPartDto> getById(@PathVariable Long id) {
        CarPartDto carPartDto = carPartService.getCarPartById(id);
        return ResponseEntity.ok(carPartDto);
    }

    @Operation(summary = "Get a car part by part number", description = "Retrieve details of a car part by its part number")
    @GetMapping("partNumber/{partNumber}")
    public ResponseEntity<CarPartDto> getCarPartByPartNumber(@PathVariable String partNumber) {
        CarPartDto carPartDto = carPartService.getCarPartByPartNumber(partNumber);
        return ResponseEntity.ok(carPartDto);
    }

    @Operation(summary = "Add a new car part", description = "Add a new car part to the system")
    @PostMapping
    public ResponseEntity<CarPartDto> createCarPart(@RequestBody CarPartDto carPartDto) {
        CarPartDto resp = carPartService.createCarPart(carPartDto);
        return resp != null ? ResponseEntity.ok(resp) : ResponseEntity.notFound().build();
    }
}
