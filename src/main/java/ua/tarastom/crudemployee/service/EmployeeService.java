package ua.tarastom.crudemployee.service;

import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findEmployee(int id);

    Employee saveOrUpdate(Employee employee);

    void deleteEmployee(int id);
}
