package com.sheet.work.time.table.service;

import com.sheet.work.time.table.convertService.ConvertProjectService;
import com.sheet.work.time.table.dto.ProjectDto;
import com.sheet.work.time.table.repository.projectRepository.ProjectRepository;
import com.sheet.work.time.table.vo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ConvertProjectService convertProjectService;

    public List<ProjectDto> getProjectDtos() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project project : projects) {
            projectDtos.add(convertProjectService.convertProject(project));
        }
        return projectDtos;
    }

    public ProjectDto getFirstProjectByName(String name) {
        Project project = projectRepository.findFirstProjectByName(name);
        return convertProjectService.convertProject(project);
    }

    public ProjectDto createProject(ProjectDto projectDto) {
        Project projectVo = convertProjectService.convertProject(projectDto);
        projectVo = projectRepository.save(projectVo);
        long idProjectVo = projectVo.getId();
        projectVo = projectRepository.findById(idProjectVo).get();
        return convertProjectService.convertProject(projectVo);
    }

    public void deleteProjectsByName(String name) {
        projectRepository.deleteProjectsByName(name);
    }

    public ProjectDto changeProjectByName(String name, ProjectDto projectDto) {
        Project project = projectRepository.findFirstProjectByName(name);
        projectDto.setId(project.getId());
        Project newProject = convertProjectService.convertProject(projectDto);
        return convertProjectService.convertProject(projectRepository.save(newProject));
    }



}
