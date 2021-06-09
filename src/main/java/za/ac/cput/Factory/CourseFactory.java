package za.ac.cput.Factory;

import java.util.UUID;
import za.ac.cput.Entity.Course;

/**
 * CourseFactory.java
 * Factory class for Course.java
 * @author Jonathan Kleynhans 217268153
 * 09 June 2021
 */

public class CourseFactory {

    public static Course build (String courseCode, String title, int departmentID, int credit, int duration,boolean fullTime){

        if(courseCode.isEmpty() || title.isEmpty() || departmentID <= 0 || credit <= 0 || duration <= 0){
            return null;
        }

        String id = UUID.randomUUID().toString();

        return new Course.CourseBuilder()
                .setCourseCode(courseCode)
                .setTitle(title)
                .setDepartmentID(departmentID)
                .setCredit(credit)
                .setDuration(duration)
                .setFullTime(fullTime)
                .build();
    }
}