package com.sambhavcodes.ipldashboard.controller;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.model.Team;
import com.sambhavcodes.ipldashboard.repository.MatchRepository;
import com.sambhavcodes.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TeamController {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        List<Match> matchList = this.matchRepository.findLatestMatchesByTeam(teamName, 4);
        team.setMatches(matchList);
        return team;
    }
}
