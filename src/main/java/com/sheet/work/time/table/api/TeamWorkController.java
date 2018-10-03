package com.sheet.work.time.table.api;

import com.sheet.work.time.table.service.EntityNotFoundException;
import com.sheet.work.time.table.service.TeamWorkService;
import com.sheet.work.time.table.vo.TeamWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})

public class TeamWorkController {
    @Autowired
    TeamWorkService teamWorkService;

    @GetMapping("/teamwork/{id}")
    @ResponseBody
    public ResponseEntity getTeamWorkById(@PathVariable Long id) {
        try {
            TeamWork teamWork = teamWorkService.getTeamWorkById(id);
            return ResponseEntity.ok(teamWork);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
