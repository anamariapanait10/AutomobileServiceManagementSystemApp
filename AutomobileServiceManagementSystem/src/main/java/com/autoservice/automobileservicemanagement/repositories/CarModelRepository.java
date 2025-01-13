package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
