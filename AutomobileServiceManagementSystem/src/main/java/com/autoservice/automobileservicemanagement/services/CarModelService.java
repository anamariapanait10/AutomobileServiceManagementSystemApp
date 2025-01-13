package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.model.entities.CarModel;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.CarModelMapper;
import com.autoservice.automobileservicemanagement.repositories.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelService {


    @Autowired
    private CarModelRepository carModelRepository;

    public CarModelDto getCarModelById(Long carModelId) {
        CarModel carModel = carModelRepository.findById(carModelId).orElse(null);
        if (carModel == null) {
            throw new DataNotFoundException("CarModel with id " + carModelId + " not found");
        }
        return CarModelDto.builder()
                .id(carModel.getId())
                .brand(carModel.getBrand())
                .model(carModel.getModel())
                .year(carModel.getYear())
                .engine(carModel.getEngine())
                .build();
    }

    public List<CarModelDto> getAllCarModels() {
        List<CarModel> carModels = carModelRepository.findAll();

        return carModels.stream().map(CarModelMapper::convertToDto).toList();
    }

    public CarModelDto addCarModel(CarModelDto carModelDto) {
        CarModel carModel = CarModelMapper.convertToCarModel(carModelDto);
        CarModel returned = carModelRepository.save(carModel);

        return CarModelMapper.convertToDto(returned);
    }
}
