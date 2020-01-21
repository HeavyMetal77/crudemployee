package ua.tarastom.crudemployee.dao;

import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findEmployee(int id);

    Employee saveOrUpdate(Employee employee);

    void deleteEmployee(int id);

}
