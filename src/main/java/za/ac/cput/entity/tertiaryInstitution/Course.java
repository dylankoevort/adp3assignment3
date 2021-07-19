package za.ac.cput.entity.tertiaryInstitution;

/**
 * Course.java
 * Course entity created using builder pattern.
 * @author Jonathan Kleynhans 217268153
 * 01 June 2021
 */

public class Course {

    private String courseCode, title;
    private int departmentID, credit, duration;
    private boolean fullTime;

    public Course(CourseBuilder course) {
        this.courseCode = course.courseCode;
        this.title = course.title;
        this.departmentID = course.departmentID;
        this.credit = course.credit;
        this.duration = course.duration;
        this.fullTime = course.fullTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", departmentID=" + departmentID +
                ", credit=" + credit +
                ", duration=" + duration +
                ", fullTime=" + fullTime +
                '}';
    }

    public static class CourseBuilder {

        private String courseCode, title;
        private int departmentID, credit, duration;
        private boolean fullTime;

        public CourseBuilder setCourseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CourseBuilder setDepartmentID(int departmentID) {
            this.departmentID = departmentID;
            return this;
        }

        public CourseBuilder setCredit(int credit) {
            this.credit = credit;
            return this;
        }

        public CourseBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public CourseBuilder setFullTime(boolean fullTime) {
            this.fullTime = fullTime;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

        public CourseBuilder copy (Course course){
            this.courseCode = course.courseCode;
            this.title = course.title;
            this.departmentID = course.departmentID;
            this.credit = course.credit;
            this.duration = course.duration;
            this.fullTime = course.fullTime;

            return this;
        }
    }
}
