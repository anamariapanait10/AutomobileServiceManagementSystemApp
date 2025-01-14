package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.services.CarModelService;
import com.autoservice.automobileservicemanagement.services.CarPartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carModels")
@Tag(name = "Car Model Management", description = "APIs for managing car models")
@RequiredArgsConstructor
public class CarModelController {

    private final CarModelService carModelService;
    private final CarPartService carPartService;

    @Operation(summary = "Get a car model by ID", description = "Retrieve a car model's details using its ID")
    @GetMapping("/{id}")
    public ResponseEntity<CarModelDto> getById(@PathVariable Long id) {
        CarModelDto o = carModelService.getCarModelById(id);
        return ResponseEntity.ok(o);
    }

    @Operation(summary = "Get all car models", description = "Retrieve a list of all car models")
    @GetMapping
    public ResponseEntity<List<CarModelDto>> getAll() {
        List<CarModelDto> o = carModelService.getAllCarModels();
        return ResponseEntity.ok(o);
    }

    @Operation(summary = "Add a new car model", description = "Add a new car model to the system")
    @PostMapping
    public ResponseEntity<CarModelDto> addCarModel(@RequestBody CarModelDto carModelDto) {
        CarModelDto o = carModelService.addCarModel(carModelDto);
        return ResponseEntity.ok(o);
    }

    @Operation(summary = "Get car parts for a model", description = "Retrieve all car parts associated with a specific car model")
    @GetMapping("/{id}/carParts")
    public ResponseEntity<List<CarPartDto>> getModelCarParts(@PathVariable Long id) {
        List<CarPartDto> carPartDtos = carPartService.getCarPartsByCarModelId(id);
        return ResponseEntity.ok(carPartDtos);
    }
}
