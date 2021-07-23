package za.ac.cput.entity.tertiaryInstitution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

/**
 * CourseTest.java
 * @author Jonathan Kleynhans 217268153
 * 09 June 2021
 */

class CourseTest {

    @Test
    void test(){
        Course course = CourseFactory.build("ADP", "Applications Development Practise", "057", 20, 3, true);
        System.out.println(course);
        assertNotNull(course);
    }
}