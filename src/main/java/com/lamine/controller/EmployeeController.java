package com.lamine.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamine.model.Employee;
import com.lamine.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Read - get all employees
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isPresent())
            return employee.get();
        else
            return null;
    }

    /**
     * Create - Add a new employee
     * 
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public Employee creatEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Update a Employee
     * 
     * @param id
     * @param employee
     * @return
     */
    @PutMapping("/employee/{id}")
    public Employee updatEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if (e.isPresent()) {
            Employee currentEmploye = e.get();
            if (employee.getFirstName() != null) {
                currentEmploye.setFirstName(employee.getFirstName());
            }
            if (employee.getLastName() != null) {
                currentEmploye.setLastName(employee.getLastName());
            }
            if (employee.getMail() != null) {
                currentEmploye.setMail(employee.getMail());
            }
            if (employee.getPassword() != null) {
                currentEmploye.setPassword(employee.getPassword());
            }
            return currentEmploye;
        } else {
            return null;
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deletEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }

}
