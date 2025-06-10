import { useEffect, useState } from "react";
import axios from "axios";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";

type Course = {
    id: number;
    language: string;
    description: string;
};

export default function CoursesTable() {
    const [courses, setCourses] = useState<Course[]>([]); // State to store fetched courses
    const [error, setError] = useState<string | null>(null); // State to store any errors

    useEffect(() => {
        fetchCourses();
    }, []);

    const fetchCourses = () => {
        axios.get("/api/courses")
            .then((response) => {
                const data = response.data;
                setCourses(Array.isArray(data) ? data : []); // Ensure data is an array
            })
            .catch((err) => {
                console.error("Error fetching courses:", err);
                setError("Failed to load courses"); // Set error message
            });
    };

    const handleDelete = (id: number) => {
        axios.delete(`/api/courses/${id}`)
            .then(() => {
                alert("Course deleted successfully!");
                fetchCourses();
            })
            .catch((err) => {
                console.error("Error deleting course:", err);
                alert("Failed to delete course.");
            });
    };

    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Available Courses</TableCell>
                        <TableCell>Actions</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {error ? (
                        <TableRow>
                            <TableCell colSpan={2} style={{ color: "red" }}>
                                {error}
                            </TableCell>
                        </TableRow>
                    ) : courses.length > 0 ? (
                        courses.map((course) => (
                            <TableRow
                                key={course.id}
                                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {course.language} - {course.description}
                                </TableCell>
                                <TableCell>
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        onClick={() => alert("Edit functionality not implemented yet")}
                                    >
                                        Edit
                                    </Button>

                                    <Button
                                        variant="contained"
                                        color="secondary"
                                        onClick={() => handleDelete(course.id)}
                                    >
                                        Delete
                                    </Button>
                                </TableCell>
                            </TableRow>
                        ))
                    ) : (
                        <TableRow>
                            <TableCell colSpan={2} style={{ textAlign: "center" }}>
                                No courses available.
                            </TableCell>
                        </TableRow>
                    )}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
