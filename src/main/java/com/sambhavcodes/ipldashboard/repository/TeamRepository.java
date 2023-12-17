package com.sambhavcodes.ipldashboard.repository;

import com.sambhavcodes.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
  Team findByTeamName(String teamName);
}
