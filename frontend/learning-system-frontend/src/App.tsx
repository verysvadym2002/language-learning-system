import "./styles.css";
import {FormInputText} from "./components/FormInputText.tsx";
import {useForm} from "react-hook-form";
import {Component} from "react";

export default class App extends Component {
    state = {
        email: "",
        password: ""
    };

    render() {
        const { control } = useForm();
        return (
            <div className="App">
                <form>
                    <FormInputText
                        name={"textInput"}
                        control={control}
                        label={"Text Input"}
                    />
                </form>
            </div>
        );
    }
}
