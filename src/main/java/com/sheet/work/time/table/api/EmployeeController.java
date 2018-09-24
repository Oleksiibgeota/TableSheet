package com.sheet.work.time.table.api;


import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.service.EmployeeService;
import com.sheet.work.time.table.service.TableException;
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

    @GetMapping(value = "/employees/{employeeId}")
    public HttpEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto != null) {
            ResponseEntity<EmployeeDto> reEmployeeDto = new ResponseEntity<>(employeeDto, HttpStatus.OK);
            System.out.println("method getBody" + " " + reEmployeeDto.getBody());
            return reEmployeeDto;
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//    @GetMapping(value = "/employees/{employeesFirstName}")
//    public HttpEntity<List<EmployeeDto>> getEmployeesByFirstName(@PathVariable String employeesFirstName) {
//        List<EmployeeDto> employeeDtos = (List<EmployeeDto>) employeeService.getEmployeesByFirstName(employeesFirstName);
//        return new ResponseEntity<List<EmployeeDto>>(employeeDtos, HttpStatus.OK);
//    }

    @GetMapping(value = "/employees/{employeeId}/team_work/{teamId}")
    public HttpEntity<EmployeeDto> getEmployeeByIdWhereTeamWorkId(@PathVariable Long employeeId, Long teamId) throws TableException {

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto != null) {
            ResponseEntity<EmployeeDto> reEmployeeDto = new ResponseEntity<>(employeeDto, HttpStatus.OK);
            System.out.println("method getBody" + " " + reEmployeeDto.getBody());
            return reEmployeeDto;
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }


    @GetMapping(value = "/employees")
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
