package com.sambhavcodes.ipldashboard.controller;

import com.sambhavcodes.ipldashboard.model.Match;
import com.sambhavcodes.ipldashboard.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping("/teams/{teamName}/matches")
    public List<Match> getAllMatchesForTeam(@PathVariable String teamName,
                                            @RequestParam(name = "year") int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }
}
