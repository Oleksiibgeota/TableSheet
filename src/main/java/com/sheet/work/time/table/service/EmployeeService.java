package com.sheet.work.time.table.service;


import com.sheet.work.time.table.repository.EmployeeRepository;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.getOne((long) 1);

//        Employee employee = employeeRepository.getOne(id);
        return employee;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    public Employee updateEmployee(Employee employee, Long id) {
        employeeRepository.getOne(id).setFirstName(employee.getFirstName());
        employeeRepository.getOne(id).setLastName(employee.getLastName());
        employeeRepository.getOne(id).setId(employee.getId());
        return employeeRepository.getOne(id);

    }
}
