import React from "react";
import {Link} from "react-router-dom";
import './YearSelector.scss';

export const YearSelector = ({teamName}) => {
  let years = [];
  const startYear = import.meta.env.VITE_APP_DATA_START_YEAR;
  const endYear = import.meta.env.VITE_APP_DATA_END_YEAR;

  for (let i = startYear; i <= endYear; i++) {
    years.push(i);
  }

  return (
      <ul className='YearSelector'>
        {
          years
          .map(
              year => <li>
                <Link to={`/teams/${teamName}/matches/${year}`}>{year}</Link>
              </li>
          )
        }
      </ul>
  )
}