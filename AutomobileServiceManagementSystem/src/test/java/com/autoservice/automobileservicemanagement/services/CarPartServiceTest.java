package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.CarPartDto;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mocks.CarModelEntitiesMocks;
import com.autoservice.automobileservicemanagement.model.entities.CarPart;
import com.autoservice.automobileservicemanagement.mappers.CarPartMapper;
import com.autoservice.automobileservicemanagement.repositories.CarPartRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarPartServiceTest {

    @InjectMocks
    private CarPartService carPartService;

    @Mock
    private CarPartRepository carPartRepository;

    @Test
    public void testGetCarPartByIdHappyUsecase() {
        CarPart carPart = CarPartMapper.mapDtoToCarPart(CarModelEntitiesMocks.getCarPartDtoListMock().get(0));
        when(carPartRepository.findById(1L)).thenReturn(Optional.of(carPart));

        CarPartDto result = carPartService.getCarPartById(1L);
        assertNotNull(result);
        assertEquals("Brake Pad", result.getName());
    }

    @Test
    public void testGetCarPartByIdUnhappyUsecase() {
        when(carPartRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> {
            carPartService.getCarPartById(999L);
        });
    }

    @Test
    public void testGetCarPartByPartNumberHappyUsecase() {
        CarPart carPart = CarPartMapper.mapDtoToCarPart(CarModelEntitiesMocks.getCarPartDtoListMock().get(0));
        when(carPartRepository.findByPartNumber("BP123")).thenReturn(carPart);

        CarPartDto result = carPartService.getCarPartByPartNumber("BP123");
        assertNotNull(result);
        assertEquals("Brake Pad", result.getName());
    }

    @Test
    public void testGetCarPartsByCarModelIdHappyUsecase() {
        List<CarPart> carParts = CarModelEntitiesMocks.getCarPartDtoListMock().stream()
                .map(CarPartMapper::mapDtoToCarPart)
                .toList();
        when(carPartRepository.findAllByCarModelId(1L)).thenReturn(carParts);

        List<CarPartDto> result = carPartService.getCarPartsByCarModelId(1L);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllCarPartsHappyUsecase() {
        List<CarPart> carParts = CarModelEntitiesMocks.getCarPartDtoListMock().stream()
                .map(CarPartMapper::mapDtoToCarPart)
                .toList();
        when(carPartRepository.findAll()).thenReturn(carParts);

        List<CarPartDto> result = carPartService.getAllCarParts();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateCarPartHappyUsecase() {
        CarPart carPart = CarPartMapper.mapDtoToCarPart(CarModelEntitiesMocks.getCarPartDtoListMock().get(0));
        when(carPartRepository.save(any(CarPart.class))).thenReturn(carPart);

        CarPartDto result = carPartService.createCarPart(CarModelEntitiesMocks.getCarPartDtoListMock().get(0));
        assertNotNull(result);
        assertEquals("Brake Pad", result.getName());
    }
}
