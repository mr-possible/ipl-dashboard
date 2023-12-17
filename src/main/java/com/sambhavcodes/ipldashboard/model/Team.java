package com.sambhavcodes.ipldashboard.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatchesPlayed;
    private long totalWins;
    @Transient
    private List<Match> matches;
}
