package com.sambhavcodes.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

  @Id
  private long id;
  private long teamName;
  private long totalMatchesPlayed;
  private long totalWins;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTeamName() {
    return teamName;
  }

  public void setTeamName(long teamName) {
    this.teamName = teamName;
  }

  public long getTotalMatchesPlayed() {
    return totalMatchesPlayed;
  }

  public void setTotalMatchesPlayed(long totalMatchesPlayed) {
    this.totalMatchesPlayed = totalMatchesPlayed;
  }

  public long getTotalWins() {
    return totalWins;
  }

  public void setTotalWins(long totalWins) {
    this.totalWins = totalWins;
  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", teamName=" + teamName +
        ", totalMatchesPlayed=" + totalMatchesPlayed +
        ", totalWins=" + totalWins +
        '}';
  }
}
