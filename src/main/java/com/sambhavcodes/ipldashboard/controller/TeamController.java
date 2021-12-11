package com.sambhavcodes.ipldashboard.controller;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.model.Team;
import com.sambhavcodes.ipldashboard.repository.MatchRepository;
import com.sambhavcodes.ipldashboard.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

  @Autowired
  private TeamRepository teamRepository;

  @Autowired
  private MatchRepository matchRepository;

  @GetMapping("/team/{teamName}")
  public Team getTeam(@PathVariable String teamName) {
    Team team = this.teamRepository.findByTeamName(teamName);
    Pageable pageable = PageRequest.of(0, 4);
    List<Match> matchList = this.matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName,
        teamName, pageable);
    team.setMatches(matchList);
    return team;
  }

}
