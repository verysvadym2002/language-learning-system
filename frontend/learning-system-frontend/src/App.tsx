import "./styles.css";
import {FormInputText} from "./components/FormInputText.tsx";
import {useForm} from "react-hook-form";
import {Button} from "@mui/material";
import axios from "axios";
import AppNavBar from "./AppBar.tsx";
import Courses from "./Courses.tsx";

const App = () => {
    const {control, handleSubmit} = useForm();

    const onSubmit = async (data: any) => {

          try {
            const response = await axios.post("http://localhost:8080/api/auth/login", data);
            console.log("Response:", response.data);
          } catch (error) {
            console.error("Error:", error);
          }
    };

    return (
        <div className="App" style={{ display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center", height: "100vh", width: "100vw", backgroundColor: "#ffffff", textAlign: "center" }}>
            <AppNavBar />
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/courses' element={<Courses/>} />
                <Route path='/contact' element={<Contact/>} />
            </Routes>
        </div>
    );
}

export default App;
