import React from "react";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {MatchDetailCard} from "../components/MatchDetailCard";

export const MatchPage = () => {
  const [matches, setMatches] = useState([]);
  const {teamName, year} = useParams();

  useEffect(
      () => {
        const fetchMatches = async () => {
          const response = await fetch(
              `http://localhost:8080/teams/${teamName}/matches?year=${year}`);
          const data = await response.json();
          setMatches(data);
        };
        fetchMatches();
      }, [] // call the hook when year changes
  );
  return (
      <div className="MatchPage">
        <h1>Match Page</h1>
        {matches.map(
            match => <MatchDetailCard teamName={teamName} match={match}/>)}
      </div>
  );
}