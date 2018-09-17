package com.sheet.work.time.table.repository;


import com.sheet.work.time.table.vo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
