package com.sheet.work.time.table.repository.employeeRepository;


import com.sheet.work.time.table.vo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByFirstName(String firstName);
    List<Employee> findAllEmployeesByTeamWorkId(Long id);



}
