package ua.tarastom.crudemployee.dao;

import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
