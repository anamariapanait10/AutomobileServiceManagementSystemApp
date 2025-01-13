package com.autoservice.automobileservicemanagement.mappers;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.model.entities.CarModel;

public class CarModelMapper {
    public static CarModelDto convertToDto(CarModel carModel){
        return CarModelDto.builder()
                .id(carModel.getId())
                .model(carModel.getModel())
                .brand(carModel.getBrand())
                .year(carModel.getYear())
                .engine(carModel.getEngine())
                .build();
    }

    public static CarModel convertToCarModel(CarModelDto carModelDto){
        return CarModel.builder()
                .model(carModelDto.getModel())
                .brand(carModelDto.getBrand())
                .year(carModelDto.getYear())
                .engine(carModelDto.getEngine())
                .build();
    }
}
