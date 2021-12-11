package com.sambhavcodes.ipldashboard.controller;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.repository.MatchRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

  @Autowired
  private MatchRepository matchRepository;

  @GetMapping("/teams/{teamName}/matches")
  public List<Match> getAllMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
    LocalDate startDate = LocalDate.of(year, 1, 1);
    LocalDate endDate = LocalDate.of(year + 1, 1, 1);
    return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
  }
}
