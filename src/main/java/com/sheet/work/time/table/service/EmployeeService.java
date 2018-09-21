package com.sheet.work.time.table.service;


import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.repository.EmployeeRepository;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.getOne(id);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        return employeeRepository.save(newEmployee);

    }

    public Employee updateEmployee(EmployeeDto employeeDto, Long id) {
        Employee newEmployee = employeeRepository.getOne(id);
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        newEmployee.setId(employeeDto.getId());
        employeeRepository.save(newEmployee);
        return newEmployee;
    }
}
