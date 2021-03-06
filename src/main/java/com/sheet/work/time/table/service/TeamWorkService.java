package com.sheet.work.time.table.service;

import com.sheet.work.time.table.dto.TeamWorkDto;
import com.sheet.work.time.table.repository.teamWorkRepository.TeamWorkRepository;
import com.sheet.work.time.table.vo.TeamWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamWorkService {
    @Autowired
    TeamWorkRepository teamWorkRepository;

    public TeamWorkDto getTeamWorkById(Long id) throws EntityNotFoundException {
        if (teamWorkRepository.existsById(id)) {
            TeamWork teamWork = teamWorkRepository.findById(id).get();
            TeamWorkDto teamWorkDto = new TeamWorkDto();
            ConvertTeamWorkVoToDto(teamWork, teamWorkDto);
            return teamWorkDto;
        } else throw new EntityNotFoundException("teamWork not found by id = " + id);
    }

    public List<TeamWorkDto> getTeamWorks() {
        List<TeamWork> teamWorks = teamWorkRepository.findAll();
        List<TeamWorkDto> teamWorkDtos = new ArrayList<>();
        for (TeamWork teamWork : teamWorks) {
            TeamWorkDto teamWorkDto = new TeamWorkDto();
            TeamWorkService.ConvertTeamWorkVoToDto(teamWork, teamWorkDto);
            teamWorkDtos.add(teamWorkDto);
        }
        return teamWorkDtos;
    }

//    public TeamWorkDto createTeamWork(TeamWorkDto teamWorkDto) throws EntityNotFoundException {
//        if (!teamWorkRepository.existTeamWorkFindByName(teamWorkDto.getName())) {
//            TeamWork teamWork = new TeamWork();
//            ConvertTeamWorkDtoToVo(teamWorkDto, teamWork);
//            teamWork = teamWorkRepository.save(teamWork);
//            ConvertTeamWorkVoToDto(teamWork, teamWorkDto);
//            return teamWorkDto;
//        } else throw new EntityNotFoundException("Team by name  " + teamWorkDto.getName() + "not possible");
//    }


    public static TeamWorkDto ConvertTeamWorkVoToDto(TeamWork teamWorkVo, TeamWorkDto teamWorkDto) {
        teamWorkDto.setId(teamWorkVo.getId());
        teamWorkDto.setName(teamWorkVo.getName());
        return teamWorkDto;
    }

    public static TeamWork ConvertTeamWorkDtoToVo(TeamWorkDto teamWorkDto, TeamWork teamWorkVo) {
        teamWorkVo.setId(teamWorkDto.getId());
        teamWorkVo.setName(teamWorkDto.getName());
        return teamWorkVo;
    }
}
