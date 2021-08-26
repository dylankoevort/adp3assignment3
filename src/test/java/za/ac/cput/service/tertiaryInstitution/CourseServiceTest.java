package za.ac.cput.service.tertiaryInstitution;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
import za.ac.cput.service.tertiaryInstitution.impl.CourseService;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CourseServiceTest {

    @Autowired
    private CourseService service;
    private static Course course = CourseFactory.build("ADP372S","Applications Development Practise","057",20, 3, true);

    @Disabled("Not needed.")
    @BeforeAll
    static void setUp(){}

    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @AfterAll
    static void tearDown(){}

    @Test
    void a_create() {
        Course created = service.create(course);
        assertEquals(course.getcourseCode(), created.getcourseCode());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Course read = service.read(course.getcourseCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Course update = new Course.CourseBuilder().copy(course).setCredit(25).build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean x = service.delete(course.getcourseCode());
        assertTrue(x);
        System.out.println("Deleted: " + x);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all: " + service.getAll());
    }
}