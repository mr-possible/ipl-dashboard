package com.sambhavcodes.ipldashboard.repository;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

  Team findByTeamName(String teamName);
}
