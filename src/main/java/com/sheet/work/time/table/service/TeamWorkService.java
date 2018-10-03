package com.sheet.work.time.table.service;

import com.sheet.work.time.table.repository.teamWorkRepository.TeamWorkRepository;
import com.sheet.work.time.table.vo.TeamWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamWorkService {
    @Autowired
    TeamWorkRepository teamWorkRepository;

    public TeamWork getTeamWorkById(Long id) throws EntityNotFoundException {
        if (teamWorkRepository.existsById(id)) {
            TeamWork teamWork = teamWorkRepository.findById(id).get();
            return teamWork;
        } else throw new EntityNotFoundException("teamWork not found by id = " + id);
    }
}
