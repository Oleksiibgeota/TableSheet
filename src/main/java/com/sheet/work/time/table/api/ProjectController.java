package com.sheet.work.time.table.api;

import com.sheet.work.time.table.dto.ProjectDto;
import com.sheet.work.time.table.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("projects/{name}")
    public @ResponseBody
    ResponseEntity getProjectByName(@PathVariable String name) {
        ProjectDto projectDto = projectService.getFirstProjectByName(name);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping("/projects")
    public @ResponseBody
    HttpEntity<ProjectDto> createNewProject(@RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.createProjectDto(projectDto), HttpStatus.OK);
    }

    @PutMapping("/projects/{name}")
    public @ResponseBody
    ResponseEntity changeProjectByName(@PathVariable String name, @RequestBody ProjectDto projectDto) {
        projectDto = projectService.changeProjectByName(name, projectDto);
        return ResponseEntity.ok(projectDto);
    }

    @DeleteMapping("/projects/{name}")
    public @ResponseBody
    ResponseEntity deleteProjectByName(@PathVariable String name) {
        projectService.deleteProjectsByName(name);
        return ResponseEntity.ok().body(name + "  is delete");
    }
}
