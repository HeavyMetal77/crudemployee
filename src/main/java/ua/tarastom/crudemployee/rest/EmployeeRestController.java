package ua.tarastom.crudemployee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.tarastom.crudemployee.entity.Employee;
import ua.tarastom.crudemployee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee getEmployees(@PathVariable int theId) {
        Employee employee = employeeService.findEmployee(theId);
        if (employee == null) {
            throw new RuntimeException("Employee id=" + theId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0); //если установлен 0 - метод добавляет
        return employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("/employees/{theId}")
    public String deleteEmployee(@PathVariable int theId) {
        Employee employee = employeeService.findEmployee(theId);
        if (employee == null) {
            throw new RuntimeException("Employee " + theId + " does not exist");
        }
        employeeService.deleteEmployee(theId);
        return "Employee id=" + theId + " deleted";
    }

    @PutMapping("/employees")
    public Employee updateEmploy(@RequestBody Employee theEmployee) {
        employeeService.saveOrUpdate(theEmployee);
        return theEmployee;
    }
}
