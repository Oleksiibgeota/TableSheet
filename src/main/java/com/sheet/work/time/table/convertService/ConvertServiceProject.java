package com.sheet.work.time.table.convertService;

import com.sheet.work.time.table.dto.ProjectDto;
import com.sheet.work.time.table.vo.Project;

public interface ConvertServiceProject {
    Project convertProject(ProjectDto projectDto);

    ProjectDto convertProject(Project project);
}
