import React from "react";
import {Link} from "react-router-dom";

export const MatchSmallCard = ({teamName, match}) => {
  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;
  return (
      <div className="MatchSmallCard">
        <h3>VS <Link to={otherTeamRoute}>{otherTeam}</Link></h3>
        <p>{match.matchWinner} won
          by <span>{match.resultMargin}</span> {match.result}</p>
      </div>);
}