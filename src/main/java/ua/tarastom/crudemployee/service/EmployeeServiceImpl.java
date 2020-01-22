package ua.tarastom.crudemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tarastom.crudemployee.dao.EmployeeRepository;
import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Var.3 using REST API with Spring Data JPA Repository

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override //    @Transactional - не нужно (предоставляется JpaRepository)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(int id) {
        Optional<Employee> result = employeeRepository.findById(id); //Optional - для проверки на null
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Employee " + id + " not found");
        }
        return theEmployee;
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }


/*
    @Autowired
    @Qualifier("employeeDAOJPAImpl")
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

 */
}
