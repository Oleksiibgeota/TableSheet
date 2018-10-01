package com.sheet.work.time.table.api;

import com.sheet.work.time.table.dto.ProjectDto;
import com.sheet.work.time.table.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public HttpEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projectDtos = projectService.projectDtos();
        return new ResponseEntity<>(projectDtos, HttpStatus.OK);

    }
}
