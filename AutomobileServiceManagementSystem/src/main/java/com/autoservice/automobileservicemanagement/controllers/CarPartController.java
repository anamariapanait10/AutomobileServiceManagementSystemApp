package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.services.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carParts")
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @GetMapping
    public ResponseEntity<List<CarPartDto>> getAll() {
        List<CarPartDto> carPartDto = carPartService.getAllCarParts();
        return ResponseEntity.ok(carPartDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarPartDto> getById(@PathVariable Long id) {
        CarPartDto carPartDto = carPartService.getCarPartById(id);
        return ResponseEntity.ok(carPartDto);
    }

    @GetMapping("partNumber/{partNumber}")
    public ResponseEntity<CarPartDto> getCarPartByPartNumber(@PathVariable String partNumber) {
        CarPartDto carPartDto = carPartService.getCarPartByPartNumber(partNumber);
        return ResponseEntity.ok(carPartDto);
    }

    @PostMapping
    public ResponseEntity<CarPartDto> createCarPart(CarPartDto carPartDto) {
        CarPartDto resp = carPartService.createCarPart(carPartDto);
        return resp != null ? ResponseEntity.ok(resp) : ResponseEntity.notFound().build();
    }

}
