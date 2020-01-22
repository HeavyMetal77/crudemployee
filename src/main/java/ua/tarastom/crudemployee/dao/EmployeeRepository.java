package ua.tarastom.crudemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tarastom.crudemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Var.3 using REST API with Spring Data JPA Repository
}
