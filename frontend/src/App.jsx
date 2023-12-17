import './App.scss';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { TeamPage } from "./pages/TeamPage.jsx";
import { MatchPage } from "./pages/MatchPage.jsx";
import { HomePage } from "./pages/HomePage.jsx";

function App() {
    return (
        <div className="App">
            <Router>
                <Routes>
                    {/* picked this route first because Routes takes acc to order */}
                    <Route path="/teams/:teamName/matches/:year" element={<MatchPage />} />
                    <Route path="/teams/:teamName" element={<TeamPage />} />
                    <Route path="/" element={<HomePage />} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;
