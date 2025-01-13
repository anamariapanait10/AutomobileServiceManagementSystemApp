package com.autoservice.automobileservicemanagement.mappers;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.model.entities.CarPart;

public class CarPartMapper {

    public static CarPartDto mapCarPartToDto(CarPart carPart) {
        if (carPart == null) {
            return null;
        }
        return CarPartDto.builder()
                .id(carPart.getId())
                .name(carPart.getName())
                .partNumber(carPart.getPartNumber())
                .price(carPart.getPrice())
                .quantity(carPart.getQuantity())
                .carModelId(carPart.getCarModelId())
                .build();
    }

    public static CarPart mapDtoToCarPart(CarPartDto carPartDto) {
        if (carPartDto == null) {
            return null;
        }
        return CarPart.builder()
                .id(carPartDto.getId())
                .name(carPartDto.getName())
                .partNumber(carPartDto.getPartNumber())
                .price(carPartDto.getPrice())
                .quantity(carPartDto.getQuantity())
                .carModelId(carPartDto.getCarModelId())
                .build();
    }

}
