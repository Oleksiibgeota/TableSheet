package com.sheet.work.time.table.ConvertService;

import com.sheet.work.time.table.dto.EmployeeDto;
import com.sheet.work.time.table.vo.Employee;

public interface ConvertServiceEmployee {
    Employee convertEmployee(EmployeeDto employeeDto);

    EmployeeDto convertEmployee(Employee employee);

}
