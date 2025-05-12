import "./styles.css";
import {FormInputText} from "./components/FormInputText.tsx";
import {useForm} from "react-hook-form";
import {Button} from "@mui/material";
import axios from "axios";
import AppNavBar from "./AppBar.tsx";
import Courses from "./Courses.tsx";
import {Route, Routes } from "react-router-dom";
import Home from "./Home.tsx";
import Cards from "./Cards.tsx";
import Users from "./Users.tsx";

const App = () => {

    return (
        <div className="App" style={{ display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center", height: "100vh", width: "100vw", backgroundColor: "#ffffff", textAlign: "center" }}>
            <AppNavBar />
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/courses' element={<Courses/>} />
                <Route path='/cards' element={<Cards/>} />
                <Route path='/users' element={<Users/>} />
            </Routes>
        </div>
    );
}

export default App;
