package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.mocks.CarModelEntitiesMocks;
import com.autoservice.automobileservicemanagement.services.CarModelService;
import com.autoservice.automobileservicemanagement.services.CarPartService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarModelControllerTest {

    @InjectMocks
    private CarModelController carModelController;

    @Mock
    private CarModelService carModelService;

    @Mock
    private CarPartService carPartService;

    @Test
    public void testGetByIdHappyUsecase() {
        when(carModelService.getCarModelById(1L)).thenReturn(CarModelEntitiesMocks.getCarModelDtoMock());

        ResponseEntity<CarModelDto> response = carModelController.getById(1L);
        assertNotNull(response.getBody());
        assertEquals("Toyota", response.getBody().getBrand());
    }

    @Test
    public void testGetAllHappyUsecase() {
        when(carModelService.getAllCarModels()).thenReturn(CarModelEntitiesMocks.getCarModelDtoListMock());

        ResponseEntity<List<CarModelDto>> response = carModelController.getAll();
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testAddCarModelHappyUsecase() {
        CarModelDto carModelDto = CarModelEntitiesMocks.getCarModelDtoMock();
        when(carModelService.addCarModel(carModelDto)).thenReturn(carModelDto);

        ResponseEntity<CarModelDto> response = carModelController.addCarModel(carModelDto);
        assertNotNull(response.getBody());
        assertEquals("Toyota", response.getBody().getBrand());
    }

    @Test
    public void testGetModelCarPartsHappyUsecase() {
        when(carPartService.getCarPartsByCarModelId(1L)).thenReturn(CarModelEntitiesMocks.getCarPartDtoListMock());

        ResponseEntity<List<CarPartDto>> response = carModelController.getModelCarParts(1L);
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }
}
