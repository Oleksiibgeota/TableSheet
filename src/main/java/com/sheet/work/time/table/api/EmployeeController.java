package com.sheet.work.time.table.api;


import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.service.EmployeeService;
import com.sheet.work.time.table.service.EntityNotFoundException;
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

    @GetMapping("/employees")
    public HttpEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getEmployees();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{employeeId}")
    public HttpEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//    @GetMapping(value = "/employees/{employeesFirstName}")
//    public HttpEntity<List<EmployeeDto>> getEmployeesByFirstName(@PathVariable String employeesFirstName) {
//        List<EmployeeDto> employeeDtos = employeeService.getEmployeesByFirstName(employeesFirstName);
//        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
//    }

    @GetMapping(value = "/employees/teamwork/{nameTeamWork}")
    public HttpEntity<List<EmployeeDto>> getEmployeesWhereTeamWorkName(@PathVariable String nameTeamWork) {
        List<EmployeeDto> employeeDtos = employeeService.getEmployeesWhereTeamWorkName(nameTeamWork);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public @ResponseBody
    ResponseEntity deleteProjectByName(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body(id + "  is delete");
    }

//    @GetMapping(value = "/employees/team_work/{teamId}")
//    public HttpEntity<EmployeeDto> getEmployeesWhereTeamWorkId(@PathVariable Long teamId) throws EntityNotFoundException {
//
//        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
//        if (employeeDto != null) {
//            ResponseEntity<EmployeeDto> reEmployeeDto = new ResponseEntity<>(employeeDto, HttpStatus.OK);
//            System.out.println("method getBody" + " " + reEmployeeDto.getBody());
//            return reEmployeeDto;
//        } else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }


    @PostMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    HttpEntity<Employee> createEmployee(@RequestBody EmployeeDto newEmployeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(newEmployeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{employeeId}")
    public @ResponseBody
    HttpEntity<EmployeeDto> replaceEmployee(@RequestBody EmployeeDto newEmployeeDto, @PathVariable Long employeeId) {
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(newEmployeeDto, employeeId), HttpStatus.OK);
    }
}
