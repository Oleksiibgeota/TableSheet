package com.sheet.work.time.table.repository.projectRepository;

import com.sheet.work.time.table.vo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
