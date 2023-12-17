import React from "react";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {MatchDetailCard} from "../components/MatchDetailCard.jsx";
import './MatchPage.scss';
import {YearSelector} from "../components/YearSelector.jsx";

export const MatchPage = () => {
  const [matches, setMatches] = useState([]);
  const {teamName, year} = useParams();

  useEffect(
      () => {
        const fetchMatches = async () => {
          const response = await fetch(
              `${import.meta.env.VITE_APP_ROOT_URL}/teams/${teamName}/matches?year=${year}`);
          const data = await response.json();
          setMatches(data);
        };
        fetchMatches();
      }, [teamName, year] // call the hook when year changes
  );
  return (
      <div className="MatchPage">
        <div className="year-selector">
          <h3>Select Year</h3>
          <YearSelector teamName={teamName}/>
        </div>
        <div>
          <h1>Match Page</h1>
          {matches.map(
              match => <MatchDetailCard teamName={teamName} match={match}/>)}
        </div>
      </div>
  );
}