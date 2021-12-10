package com.sambhavcodes.ipldashboard.data;

import com.sambhavcodes.ipldashboard.model.Team;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(
      JobCompletionNotificationListener.class);

  private final EntityManager entityManager;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate,
      EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("## JOB FINISHED ##");
      Map<String, Team> teamData = new HashMap<>();
      entityManager
          .createQuery("SELECT m.team1, count(m) FROM Match m group by m.team1", Object[].class)
          .getResultList()
          .stream()
          .map(e -> new Team((String) e[0], (Long) e[1]))
          .forEach(team -> teamData.put(team.getTeamName(), team));
      entityManager
          .createQuery("SELECT m.team2, count(m) FROM Match m group by m.team2", Object[].class)
          .getResultList()
          .forEach(e -> {
            Team team = teamData.get((String) e[0]);
            team.setTotalMatchesPlayed(team.getTotalMatchesPlayed() + (Long) e[1]);
          });
      entityManager.createQuery(
              "SELECT m.matchWinner, count(m) FROM Match m GROUP BY m.matchWinner", Object[].class)
          .getResultList().forEach(e -> {
            Team team = teamData.get((String) e[0]);
            if (team != null) {
              team.setTotalWins((Long) e[1]);
            }
          });

      // Finally, persisting the data filtered / cleaned above.
      teamData.values().forEach(entityManager::persist);
      teamData.values().forEach(team -> log.info(String.valueOf(team)));
    }
  }
}