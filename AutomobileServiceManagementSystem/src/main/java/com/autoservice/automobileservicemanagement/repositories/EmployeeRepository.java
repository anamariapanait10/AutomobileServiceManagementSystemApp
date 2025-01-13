package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findUserByUsername(String username);

    @Query("SELECT u from Employee u where u.username = :username AND u.userType = :userType")
    List<Employee> findUserByCustomQuery(String username, String userType);
}
