package za.ac.cput.Factory;

import za.ac.cput.Entity.Subject;
/**
 * SubjectFactory.java
 * Created Factory class called SubjectFactory for Subject entity
 * Author: Shane Knoll (218279124)
 * Date:10 June 2021
 */


public class SubjectFactory {

    public static Subject build(int subjectCode, String subjectName, int lecturerID, String courseCode, int semesterID) {

        if(subjectCode<=0||subjectName.isEmpty()||lecturerID<=0||courseCode.isEmpty()||semesterID<=0)
            return null;

        return new Subject.SubjectBuilder()
                .setsubjectCode(subjectCode).setsubjectName(subjectName).setlecturerID(lecturerID).setcourseCode(courseCode).setsemesterID(semesterID).build();

    }


}
