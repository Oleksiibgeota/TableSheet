package com.sheet.work.time.table.api;


import com.sheet.work.time.table.service.EmployeeService;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{employeeId}")
    public @ResponseBody
    HttpEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/addNewEmployee")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public @ResponseBody
    HttpEntity<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.updateEmployee(newEmployee, employeeId), HttpStatus.OK);
    }
}
