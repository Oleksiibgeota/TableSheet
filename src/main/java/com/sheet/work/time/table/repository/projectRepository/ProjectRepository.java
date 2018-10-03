package com.sheet.work.time.table.repository.projectRepository;

import com.sheet.work.time.table.vo.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Transactional
    void deleteProjectsByName(String name);
    Project findFirstProjectByName(String name);
}
