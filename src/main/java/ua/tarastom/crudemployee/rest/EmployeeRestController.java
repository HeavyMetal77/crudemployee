package ua.tarastom.crudemployee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tarastom.crudemployee.dao.EmployeeDAO;
import ua.tarastom.crudemployee.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employeeList = employeeDAO.findAll();
        return employeeList;
    }
}
