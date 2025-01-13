package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.CarModelDto;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mocks.CarModelEntitiesMocks;
import com.autoservice.automobileservicemanagement.model.entities.CarModel;
import com.autoservice.automobileservicemanagement.mappers.CarModelMapper;
import com.autoservice.automobileservicemanagement.repositories.CarModelRepository;

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
public class CarModelServiceTest {

    @InjectMocks
    private CarModelService carModelService;

    @Mock
    private CarModelRepository carModelRepository;

    @Test
    public void testGetCarModelByIdHappyUsecase() {
        CarModel carModel = CarModelMapper.convertToCarModel(CarModelEntitiesMocks.getCarModelDtoMock());
        when(carModelRepository.findById(1L)).thenReturn(Optional.of(carModel));

        CarModelDto result = carModelService.getCarModelById(1L);
        assertNotNull(result);
        assertEquals("Toyota", result.getBrand());
    }

    @Test
    public void testGetCarModelByIdUnhappyUsecase() {
        when(carModelRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> {
            carModelService.getCarModelById(999L);
        });
    }

    @Test
    public void testGetAllCarModelsHappyUsecase() {
        List<CarModel> carModels = CarModelEntitiesMocks.getCarModelDtoListMock().stream()
                .map(CarModelMapper::convertToCarModel)
                .toList();
        when(carModelRepository.findAll()).thenReturn(carModels);

        List<CarModelDto> result = carModelService.getAllCarModels();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddCarModelHappyUsecase() {
        CarModel carModel = CarModelMapper.convertToCarModel(CarModelEntitiesMocks.getCarModelDtoMock());
        when(carModelRepository.save(any(CarModel.class))).thenReturn(carModel);

        CarModelDto result = carModelService.addCarModel(CarModelEntitiesMocks.getCarModelDtoMock());
        assertNotNull(result);
        assertEquals("Toyota", result.getBrand());
    }
}
