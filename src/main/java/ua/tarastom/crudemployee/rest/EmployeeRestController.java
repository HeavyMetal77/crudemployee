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
            throw new RuntimeException("Employee " + theId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee theEmployee = employeeService.saveOrUpdate(employee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{theId}")
    public void deleteEmployee(@PathVariable int theId) {
        employeeService.deleteEmployee(theId);
    }
}
