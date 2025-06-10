import AddCourseForm from "./components/AddCourseForm";
import CoursesTable from "./components/CoursesTable";

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