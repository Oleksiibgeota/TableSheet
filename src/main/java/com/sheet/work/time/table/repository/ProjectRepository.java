package com.sheet.work.time.table.repository;

import com.sheet.work.time.table.vo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
