package com.sambhavcodes.ipldashboard.repository;

import com.sambhavcodes.ipldashboard.model.Match;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

  List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2,
      Pageable pageable);

  @Query(value = "select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date BETWEEN :startDate and :endDate order by m.date desc")
  List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName,
      @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

  default List<Match> findLatestMatchesByTeam(String teamName, int count) {
    Pageable pageable = PageRequest.of(0, count);
    return this.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable);
  }
}
