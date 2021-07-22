package za.ac.cput.repository.tertiaryInstitution.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CourseRepositoryTest.java
 * Test cases for Course Repository implementation
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
class CourseRepositoryTest {
    private static CourseRepository repository = CourseRepository.getRepository();
    private static Course course = CourseFactory.build("PRJ258","PROJECT", "057", 20, 3,true);

    @Test
    void a_create(){
        Course created = repository.create(course);
        assertEquals(course.getcourseCode(), created.getcourseCode());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read(){
        Course read = repository.read(course.getcourseCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Course updated = new Course.CourseBuilder().copy(course).setCredit(15).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete(){
        boolean x = repository.delete(course.getcourseCode());
        assertTrue(x);
        System.out.println("Deleted: " + x);
    }

    @Test
    void d_getAll(){
        System.out.println("Display all: \n" + repository.getAll());
    }

}