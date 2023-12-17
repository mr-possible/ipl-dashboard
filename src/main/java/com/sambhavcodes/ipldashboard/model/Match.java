package com.sambhavcodes.ipldashboard.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Match {
    @Id
    private Long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String result;
    private String resultMargin;
    private String umpire1;
    private String umpire2;
}
