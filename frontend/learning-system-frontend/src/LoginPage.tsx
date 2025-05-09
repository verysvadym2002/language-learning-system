import {FormInputText} from "./components/FormInputText.tsx";
import {Button} from "@mui/material";

const LoginPage = () => {
    return (
        <div className="App" style={{ display: "flex", flexDirection: "column", justifyContent: "center", alignItems: "center", height: "100vh", width: "100vw", backgroundColor: "#ffffff", textAlign: "center" }}>

            <h1 style={{ textAlign: "center", marginBottom: "1.5rem" }}>Learning System</h1>
            <div style={{ padding: "2rem", border: "1px solid #ccc", borderRadius: "8px", boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)" }}>

                <form onSubmit={handleSubmit(onSubmit)} style={{ display: "flex", flexDirection: "column", gap: "1rem" }}>
                    <FormInputText
                        name={"username"}
                        control={control}
                        label={"Username"}
                    />
                    <FormInputText
                        name={"password"}
                        control={control}
                        label={"Password"}
                    />
                    <Button type="submit" variant={"contained"} color="primary">
                        Login
                    </Button>
                </form>
            </div>
        </div>
    )
}