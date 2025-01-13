package com.autoservice.automobileservicemanagement.mocks;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.dto.CarPartDto;

import java.util.ArrayList;
import java.util.List;

public class CarModelEntitiesMocks {

    public static CarModelDto getCarModelDtoMock() {
        return CarModelDto.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .year("2020")
                .engine("1.8L")
                .build();
    }

    public static List<CarModelDto> getCarModelDtoListMock() {
        List<CarModelDto> list = new ArrayList<>();
        list.add(getCarModelDtoMock());
        list.add(CarModelDto.builder()
                .id(2L)
                .brand("Honda")
                .model("Civic")
                .year("2021")
                .engine("2.0L")
                .build());
        return list;
    }

    public static List<CarPartDto> getCarPartDtoListMock() {
        List<CarPartDto> list = new ArrayList<>();
        list.add(CarPartDto.builder()
                .id(1L)
                .name("Brake Pad")
                .partNumber("BP123")
                .price(100)
                .quantity(50)
                .carModelId(1L)
                .build());
        list.add(CarPartDto.builder()
                .id(2L)
                .name("Engine Oil")
                .partNumber("EO456")
                .price(30)
                .quantity(200)
                .carModelId(1L)
                .build());
        return list;
    }
}
