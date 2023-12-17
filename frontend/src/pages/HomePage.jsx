import React, {useEffect, useState} from "react";
import {TeamTile} from "../components/TeamTile.jsx";
import './HomePage.scss';

export const HomePage = () => {
  const [teams, setTeams] = useState([]);

  useEffect(() => {
    const fetchAllTeams = async () => {
      const response = fetch(`${import.meta.env.VITE_APP_ROOT_URL}/teams`);
      const data = (await response).json();
      setTeams(await data);
    };
    fetchAllTeams();
  }, []);

  return (
      <div className="HomePage">
        <div className="header-section">
          <h1 className="app-name">IPL Dashboard</h1>
        </div>
        <div className="team-grid">
          {
            teams.map(team => <TeamTile teamName={team.teamName} />)
          }
        </div>
      </div>
  );
}