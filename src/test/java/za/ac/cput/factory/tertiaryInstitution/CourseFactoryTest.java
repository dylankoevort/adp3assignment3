package za.ac.cput.factory.tertiaryInstitution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

/**
 * CourseFactoryTest.java
 * @author Jonathan Kleynhans 217268153
 * 09 June 2021
 */

class CourseFactoryTest {

    @Test
    void test(){
        Course course = CourseFactory.build("ADP262", "Applications Development Practise", "021", 20, 3, true);
        System.out.println(course);
        assertNotNull(course);
    }
}