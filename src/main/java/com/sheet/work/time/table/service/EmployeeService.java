package com.sheet.work.time.table.service;


import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.repository.employeeRepository.EmployeeRepository;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto getEmployeeById(Long id) throws EntityNotFoundException {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.findById(id).get();
            EmployeeDto employeeDto = new EmployeeDto();
            System.out.println("EmployeeService findById" + " " + employee);
            EmployeeService.ConvertEmployeeVoToDto(employee, employeeDto);
            return employeeDto;
        } else throw new EntityNotFoundException("employee not found by id " + id);
    }

    public List<EmployeeDto> getEmployeesByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findEmployeesByFirstName(firstName);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            System.out.println(employee);
            EmployeeDto employeeDto = new EmployeeDto();
            EmployeeService.ConvertEmployeeVoToDto(employee, employeeDto);
            employeeDtos.add(employeeDto);
        }
        return  employeeDtos;
    }


    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            EmployeeService.ConvertEmployeeVoToDto(employee, employeeDto);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }


//    get all Employee where TeamWork id=?

    public List<EmployeeDto> getEmployeesWhereTeamWorkId(String nameTeamWork) {
        List<Employee> employees = employeeRepository.findAllEmployeesByTeamWorkName(nameTeamWork);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            EmployeeService.ConvertEmployeeVoToDto(employee, employeeDto);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        return employeeRepository.save(newEmployee);

    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
        Employee newEmployee = employeeRepository.getOne(id);
//        ConvertEmployeeDtoToVo(employeeDto,newEmployee);
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        newEmployee.setId(employeeDto.getId());
        employeeRepository.save(newEmployee);
        return employeeDto;
    }

    public static EmployeeDto ConvertEmployeeVoToDto(Employee employeeVo, EmployeeDto employeeDto) {
        employeeDto.setId(employeeVo.getId());
        employeeDto.setFirstName(employeeVo.getFirstName());
        employeeDto.setLastName(employeeVo.getLastName());
        return employeeDto;
    }

    public static Employee ConvertEmployeeDtoToVo(EmployeeDto employeeDto, Employee employeeVo) {
        employeeVo.setId(employeeDto.getId());
        employeeVo.setFirstName(employeeDto.getFirstName());
        employeeVo.setLastName(employeeDto.getLastName());
        return employeeVo;
    }
}



