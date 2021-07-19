package za.ac.cput.entity.curriculum;
/**
 * Subject.java
 * Created Entity for the Subject using builder pattern.
 * Author: Shane Knoll (218279124)
 * Date:01 June 2021
 */

public class Subject {
    //this is my instance variables/attributes for th entity class Subject:
    private int subjectCode;
    private String subjectName;
    private int lecturerID;
    private String courseCode;
    private int semesterID;

    private Subject(SubjectBuilder b){
        this.subjectCode=b.subjectCode;
        this.subjectName=b.subjectName;
        this.lecturerID=b.lecturerID;
        this.courseCode=b.courseCode;
        this.semesterID=b.semesterID;

    }

    //this is the static class SubjectBuilder/builder class in the Subject Entity
    public static class SubjectBuilder{
        private int subjectCode;
        private String subjectName;
        private int lecturerID;
        private String courseCode;
        private int semesterID;

        //all the setters in SubjectBuilder static class:
        public SubjectBuilder setsubjectCode(int subjectCode){

            this.subjectCode=subjectCode;
            return this;
        }

        public SubjectBuilder setsubjectName(String subjectname){

            subjectName=subjectname;
            return this;
        }

        public SubjectBuilder setlecturerID(int lectureriD){

            lecturerID=lectureriD;
            return this;
        }
        public SubjectBuilder setcourseCode(String coursecode){

            this.courseCode=coursecode;
            return this;
        }
        public SubjectBuilder setsemesterID(int semesteriD){

            semesterID=semesteriD;
            return this;
        }


        public Subject build(){

            return new Subject(this);
        }


    }
//toString for the Subject class
    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode=" + subjectCode +
                ", subjectName='" + subjectName + '\'' +
                ", lecturerID=" + lecturerID +
                ", courseCode='" + courseCode + '\'' +
                ", semesterID=" + semesterID +
                '}';
    }
}
