import AddCourseForm from "../components/AddCourseForm.tsx";
import CoursesTable from "../components/CoursesTable.tsx";

const Courses = () => {
    return (
        <div>
            <h1>Courses</h1>
            <AddCourseForm />
            <CoursesTable />
        </div>
    );
};

export default Courses;