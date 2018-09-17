package com.sheet.work.time.table.dto;

import com.sheet.work.time.table.vo.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
}
