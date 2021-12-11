package com.sambhavcodes.ipldashboard.controller;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.model.Team;
import com.sambhavcodes.ipldashboard.repository.MatchRepository;
import com.sambhavcodes.ipldashboard.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    List<Match> matchList = this.matchRepository.findLatestMatchesByTeam(teamName, 4);
    team.setMatches(matchList);
    return team;
  }
}