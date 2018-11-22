package com.sheet.work.time.table.convertService;

import com.sheet.work.time.table.dto.ProjectDto;
import com.sheet.work.time.table.vo.Project;

public class ConvertProjectService implements ConvertServiceProject {
    @Override
    public Project convertProject(ProjectDto projectDto) {
        Project projectVo = new Project();
        projectVo.setId(projectDto.getId());
        projectVo.setName(projectDto.getName());
        projectVo.setAddress(projectDto.getAddress());
        projectVo.setDescription(projectDto.getDescription());
        return projectVo;
    }

    @Override
    public ProjectDto convertProject(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setAddress(project.getAddress());
        projectDto.setDescription(project.getDescription());
        return projectDto;


    }
}
