package ua.tarastom.crudemployee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.tarastom.crudemployee.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{ //Var.2 using JPA API

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee findEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:theId");
        query.setParameter("theId", id);
        query.executeUpdate();
    }
}
