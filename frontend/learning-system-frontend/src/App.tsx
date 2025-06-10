import "./styles.css";
import { Routes, Route, useNavigate } from "react-router-dom";
import AppNavBar from "./AppBar.tsx";
import Home from "./Home.tsx";
import Courses from "./Courses.tsx";
import Cards from "./Cards.tsx";
import Users from "./Users.tsx";
import LoginPage from "./LoginPage.tsx";

const App = () => {
    const navigate = useNavigate();
    const authToken = localStorage.getItem("authToken"); // Check if the user is authenticated

    const handleLogout = () => {
        localStorage.removeItem("authToken"); // Clear token from localStorage
        navigate("/login"); // Redirect to login page
    };

    return (
        <div className="App" style={{ display: "flex", flexDirection: "column", height: "100vh", width: "100vw", backgroundColor: "#ffffff", textAlign: "center" }}>
            <AppNavBar />
            {authToken && ( // Conditionally render the Logout button
                <button onClick={handleLogout} style={{ position: "absolute", top: "1rem", right: "1rem" }}>
                    Logout
                </button>
            )}
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/" element={<Home />} />
                <Route path="/courses" element={<Courses />} />
                <Route path="/cards" element={<Cards courseId={1} />} />
                <Route path="/users" element={<Users />} />
            </Routes>
        </div>
    );
};

export default App;
