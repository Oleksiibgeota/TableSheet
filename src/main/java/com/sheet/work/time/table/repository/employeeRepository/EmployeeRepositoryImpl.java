package com.sheet.work.time.table.repository.employeeRepository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional(readOnly = true)
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


}