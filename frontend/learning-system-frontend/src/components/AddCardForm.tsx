import React, { useState } from "react";

const AddCardForm = ({ courseId, onCardAdded }: { courseId: number; onCardAdded: () => void }) => {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const response = await fetch(`http://localhost:8080/api/cards/`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ title, description, courseId }),
        });
        if (response.ok) {
            onCardAdded();
            setTitle("");
            setDescription("");
        } else {
            alert("Failed to add card");
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Description:</label>
                <textarea
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Add Card</button>
        </form>
    );
};

export default AddCardForm;