package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.services.CarModelService;
import com.autoservice.automobileservicemanagement.services.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carModels")
public class CarModelController {
    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarPartService carPartService;

    @GetMapping("/{id}")
    public ResponseEntity<CarModelDto> getById(@PathVariable Long id) {
        CarModelDto o = carModelService.getCarModelById(id);
        return ResponseEntity.ok(o);
    }

    @GetMapping
    public ResponseEntity<List<CarModelDto>> getAll() {
        List<CarModelDto> o = carModelService.getAllCarModels();
        return ResponseEntity.ok(o);
    }

    @PostMapping
    public ResponseEntity<CarModelDto> addCarModel(CarModelDto carModelDto) {
        CarModelDto o = carModelService.addCarModel(carModelDto);
        return ResponseEntity.ok(o);
    }

    @GetMapping("/{id}/carParts")
    public ResponseEntity<List<CarPartDto>> getModelCarParts(@PathVariable Long id) {
        List<CarPartDto> carPartDtos = carPartService.getCarPartsByCarModelId(id);
        return ResponseEntity.ok(carPartDtos);
    }
}
