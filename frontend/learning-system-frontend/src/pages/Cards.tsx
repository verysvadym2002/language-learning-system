import { useState, useEffect } from "react";
import AddCardForm from "../components/AddCardForm.tsx";

type Card = {
    id: number;
    title: string;
    description: string;
};

const Cards = ({ courseId }: { courseId: number }) => {
    const [cards, setCards] = useState<Card[]>([]);
    const [selectedCardIndex, setSelectedCardIndex] = useState(0);

    useEffect(() => {
        fetch(`/api/cards?courseId=${courseId}`)
            .then((res) => res.json())
            .then((data) => setCards(data));
    }, [courseId]);

    const handleDelete = async (cardId: number) => {
        const response = await fetch(`/api/cards/${cardId}`, { method: "DELETE" });
        if (response.ok) {
            setCards(cards.filter((card) => card.id !== cardId));
        } else {
            alert("Failed to delete card");
        }
    };

    const handleCardAdded = () => {
        fetch(`/api/cards?courseId=${courseId}`)
            .then((res) => res.json())
            .then((data) => setCards(data));

    };

    return (
        <div>
            <h1>Cards for Course {courseId}</h1>
            <AddCardForm courseId={courseId} onCardAdded={handleCardAdded} />
            {cards.length > 0 && (
                <div>
                    <h2>{cards[selectedCardIndex].title}</h2>
                    <p>{cards[selectedCardIndex].description}</p>
                    <button
                        onClick={() =>
                            setSelectedCardIndex((selectedCardIndex + 1) % cards.length)
                        }
                    >
                        Next Card
                    </button>
                    <button onClick={() => handleDelete(cards[selectedCardIndex].id)}>
                        Delete Card
                    </button>
                </div>
            )}
        </div>
    );
};

export default Cards;