package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.mocks.CarModelEntitiesMocks;
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
public class CarPartControllerTest {

    @InjectMocks
    private CarPartController carPartController;

    @Mock
    private CarPartService carPartService;

    @Test
    public void testGetAllHappyUsecase() {
        when(carPartService.getAllCarParts()).thenReturn(CarModelEntitiesMocks.getCarPartDtoListMock());

        ResponseEntity<List<CarPartDto>> response = carPartController.getAll();
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetByIdHappyUsecase() {
        CarPartDto carPartDto = CarModelEntitiesMocks.getCarPartDtoListMock().get(0);
        when(carPartService.getCarPartById(1L)).thenReturn(carPartDto);

        ResponseEntity<CarPartDto> response = carPartController.getById(1L);
        assertNotNull(response.getBody());
        assertEquals("Brake Pad", response.getBody().getName());
    }

    @Test
    public void testGetCarPartByPartNumberHappyUsecase() {
        CarPartDto carPartDto = CarModelEntitiesMocks.getCarPartDtoListMock().get(0);
        when(carPartService.getCarPartByPartNumber("BP123")).thenReturn(carPartDto);

        ResponseEntity<CarPartDto> response = carPartController.getCarPartByPartNumber("BP123");
        assertNotNull(response.getBody());
        assertEquals("Brake Pad", response.getBody().getName());
    }

    @Test
    public void testCreateCarPartHappyUsecase() {
        CarPartDto carPartDto = CarModelEntitiesMocks.getCarPartDtoListMock().get(0);
        when(carPartService.createCarPart(carPartDto)).thenReturn(carPartDto);

        ResponseEntity<CarPartDto> response = carPartController.createCarPart(carPartDto);
        assertNotNull(response.getBody());
        assertEquals("Brake Pad", response.getBody().getName());
    }
}
