import React from "react";
import {Link} from "react-router-dom";

export const MatchDetailCard = ({teamName, match}) => {
  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  if (!match) {
    return null;
  }
  return (<div className="MatchDetailCard">
    <h3>Latest Matches</h3>
    <h4>Match Details</h4>
    <h1>VS <Link to={otherTeamRoute}>{otherTeam}</Link></h1>
    <h2>Played on : {match.date}</h2>
    <h3>Played at : {match.venue}</h3>
    <h3>{match.matchWinner} won by <span>{match.resultMargin}</span> {match.result}</h3>
  </div>);
}