package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.model.entities.CarPart;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.CarPartMapper;
import com.autoservice.automobileservicemanagement.repositories.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    public CarPartDto getCarPartById(Long id) {
        CarPart cp = carPartRepository.findById(id).orElse(null);
        if (cp == null) {
            throw new DataNotFoundException("Car part with id " + id + " not found");
        }
        return CarPartMapper.mapCarPartToDto(cp);
    }

    public CarPartDto getCarPartByPartNumber(String partNumber) {
        CarPart cp = carPartRepository.findByPartNumber(partNumber);
        if (cp == null) {
            throw new DataNotFoundException("Car part with part number " + partNumber + " not found");
        }
        return CarPartMapper.mapCarPartToDto(cp);
    }

    public List<CarPartDto> getCarPartsByCarModelId(Long carModelId) {
        return carPartRepository.findAllByCarModelId(carModelId).stream()
                .map(CarPartMapper::mapCarPartToDto)
                .toList();
    }

    public CarPartDto createCarPart(CarPartDto carPartDto) {
        return CarPartMapper.mapCarPartToDto(carPartRepository.save(CarPartMapper.mapDtoToCarPart(carPartDto)));
    }


    public List<CarPartDto> getAllCarParts() {
        return carPartRepository.findAll().stream()
                .map(CarPartMapper::mapCarPartToDto)
                .toList();
    }
}
