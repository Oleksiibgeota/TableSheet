package com.sheet.work.time.table.service;

import com.sheet.work.time.table.dto.TeamWorkDto;
import com.sheet.work.time.table.repository.teamWorkRepository.TeamWorkRepository;
import com.sheet.work.time.table.vo.TeamWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
