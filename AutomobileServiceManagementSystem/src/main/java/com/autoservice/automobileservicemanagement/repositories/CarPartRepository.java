package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {

    List<CarPart> findAllByCarModelId(Long carModelId);
    CarPart findByPartNumber(String carPartNumber);
}
