package com.sheet.work.time.table.repository.teamWorkRepository;

import com.sheet.work.time.table.vo.TeamWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TeamWorkRepository extends JpaRepository<TeamWork, Long> {
//    @Transactional
//    boolean existTeamWorkFindByName(String name);
}
