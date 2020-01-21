package ua.tarastom.crudemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tarastom.crudemployee.dao.EmployeeDAO;
import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findEmployee(int id) {
        return employeeDAO.findEmployee(id);
    }

    @Override
    @Transactional
    public Employee saveOrUpdate(Employee employee) {
        return employeeDAO.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
