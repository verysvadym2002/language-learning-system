import { useState } from "react";
import axios from "axios";

const AddCourseForm = () => {
    const [language, setLanguage] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        axios.post("/api/courses", { language, description })
            .then(() => {
                alert("Course added successfully!");
                setLanguage("");
                setDescription("");
            })
            .catch((err) => {
                console.error("Error adding course:", err);
                alert("Failed to add course.");
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Language:</label>
                <input
                    type="text"
                    value={language}
                    onChange={(e) => setLanguage(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Description:</label>
                <input
                    type="text"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Add Course</button>
        </form>
    );
};

export default AddCourseForm;