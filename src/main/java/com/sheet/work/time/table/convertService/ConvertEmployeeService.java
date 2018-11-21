package com.sheet.work.time.table.convertService;

import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.vo.Employee;
import org.springframework.stereotype.Service;

@Service
public  class ConvertEmployeeService implements ConvertServiceEmployee {
    @Override
    public Employee convertEmployee(EmployeeDto employeeDto) {
        Employee employeeVo = new Employee();
        employeeVo.setId(employeeDto.getId());
        employeeVo.setFirstName(employeeDto.getFirstName());
        employeeVo.setLastName(employeeDto.getLastName());
        return employeeVo;
    }

    @Override
    public EmployeeDto convertEmployee(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }
}
