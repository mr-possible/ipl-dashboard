import React from "react";
import {Link} from "react-router-dom";
import './MatchDetailCard.scss';

export const MatchDetailCard = ({teamName, match}) => {
  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  const isMatchWon = teamName === match.matchWinner;

  if (!match) {
    return null;
  }
  return (<div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
        <div>
          <span className="vs-text"><b>VS</b></span>
          <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
          <h2 className="match-date">Played on : {match.date}</h2>
          <h3 className="match-venue">Played at : {match.venue}</h3>
          <h3 className="match-result">{match.matchWinner} won
            by <span>{match.resultMargin}</span> {match.result}</h3>
        </div>
        <div className="additional-details">
          <h3>Toss won by</h3><p>{match.tossWinner} & chose
          to {match.tossDecision}</p>
          <h3>First Innings</h3><p>{match.team1}</p>
          <h3>Second Innings</h3><p>{match.team2}</p>
          <h3>Man Of the Match</h3><p>{match.playerOfMatch}</p>
          <h3>Umpires</h3><p>{match.umpire1} , {match.umpire2}</p>
        </div>
      </div>);
}