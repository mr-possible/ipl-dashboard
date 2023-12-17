import React, {useEffect, useState} from "react";
import {useParams, Link} from "react-router-dom";
import {MatchDetailCard} from "../components/MatchDetailCard.jsx";
import {MatchSmallCard} from "../components/MatchSmallCard.jsx";
import {PieChart} from 'react-minimal-pie-chart';
import './TeamPage.scss';

export const TeamPage = () => {
  const [team, setTeam] = useState({matches: []});
  const {teamName} = useParams();

  useEffect(
      () => {
        const fetchMatches = async () => {
          const response = await fetch(
              `${import.meta.env.VITE_APP_ROOT_URL}/team/${teamName}`);
          const data = await response.json();
          setTeam(data);
        };
        fetchMatches();
      }, [teamName] // call the hook when teamName changes
  );

  if (!team || !team.teamName) {
    return <h1>Team not found !</h1>
  }
  return (
      <div className="TeamPage">
        <div className="team-name-section">
          <h1 className="team-name">{team.teamName}</h1>
        </div>
        <div className="win-loss-section">
          <PieChart
              data={[
                {title: 'Wins', value: team.totalWins, color: 'green'},
                {
                  title: 'Losses',
                  value: (team.totalMatchesPlayed) - (team.totalWins),
                  color: '#C13C37'
                }
              ]}
          />
          <p>Win/Losses</p>
        </div>
        <div className="match-detail-section">
          <h3>Latest Matches</h3>
          <br/>
          <MatchDetailCard teamName={team.teamName} match={team.matches[0]}/>
        </div>
        {team.matches.slice(1).map(
            match => (
                <MatchSmallCard teamName={team.teamName} match={match}/>
            ))}
        <div className="more-link-section">
          <Link to={`/teams/${teamName}/matches/${import.meta.env.VITE_APP_DATA_END_YEAR}`}>More... </Link>
        </div>
      </div>
  );
}