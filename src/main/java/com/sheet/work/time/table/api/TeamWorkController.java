package com.sheet.work.time.table.api;

import com.sheet.work.time.table.dto.TeamWorkDto;
import com.sheet.work.time.table.service.EntityNotFoundException;
import com.sheet.work.time.table.service.TeamWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})

public class TeamWorkController {
    @Autowired
    TeamWorkService teamWorkService;

    @GetMapping("/teamwork/{id}")
    @ResponseBody
    public ResponseEntity getTeamWorkById(@PathVariable Long id) {
        try {
            TeamWorkDto teamWorkDto = teamWorkService.getTeamWorkById(id);
            return ResponseEntity.ok(teamWorkDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/teamworks")
    public ResponseEntity getAllTeamWork() {
        List<TeamWorkDto> teamWorkDtos = teamWorkService.getTeamWorks();
        return ResponseEntity.ok(teamWorkDtos);
    }

//    @PostMapping("/addNewTeamWork")
//    @ResponseBody
//    public ResponseEntity createTeamWork(@RequestBody TeamWorkDto teamWorkDto) throws EntityNotFoundException {
//        try {
//            teamWorkDto = teamWorkService.createTeamWork(teamWorkDto);
//            return ResponseEntity.ok(teamWorkDto);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
}
