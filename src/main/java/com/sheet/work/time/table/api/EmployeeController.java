package com.sheet.work.time.table.api;


import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.service.EmployeeService;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public HttpEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        System.out.println(employeeDto);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public HttpEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PostMapping(path = "/addNewEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    HttpEntity<Employee> newEmployee(@RequestBody EmployeeDto newEmployeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(newEmployeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public @ResponseBody
    HttpEntity<EmployeeDto> replaceEmployee(@RequestBody EmployeeDto newEmployeeDto, @PathVariable Long employeeId) {
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(newEmployeeDto, employeeId), HttpStatus.OK);
    }
}
