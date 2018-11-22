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
        ConvertProjectDtoToVo(projectDto, project);
        project = projectRepository.save(project);
        ConvertProjectVoToDto(project, projectDto);
        return projectDto;
    }

    public static ProjectDto ConvertProjectVoToDto(Project projectVo, ProjectDto projectDto) {
        projectDto.setId(projectVo.getId());
        projectDto.setName(projectVo.getName());
        projectDto.setAddress(projectVo.getAddress());
        projectDto.setDescription(projectVo.getDescription());
        return projectDto;
    }

    public static Project ConvertProjectDtoToVo(ProjectDto projectDto, Project projectVo) {
        projectVo.setId(projectDto.getId());
        projectVo.setName(projectDto.getName());
        projectVo.setAddress(projectDto.getAddress());
        projectVo.setDescription(projectDto.getDescription());
        return projectVo;
    }

}
