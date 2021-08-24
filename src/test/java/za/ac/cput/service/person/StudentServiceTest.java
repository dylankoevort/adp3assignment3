package za.ac.cput.service.person;

/**
 *
 * StudentServiceTest.java
 * Unit tests for StudentService implementation
 * @author Dylan Koevort 218088159
 * 26 July 2021
 *
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.person.Student;
import za.ac.cput.factory.person.StudentFactory;
import za.ac.cput.service.person.impl.StudentService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService service;
    private static Student student = StudentFactory.build("Dylan", "Koevort", "218088@mycput.com", "0731234567", 21);

    @Test
    void a_create() {
        Student created = service.create(student);
        assertEquals(student.getStudentId(), created.getStudentId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Student read = service.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Student updated = new Student.StudentBuilder().copy(student).setAge(31).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = service.delete(student.getStudentId());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }

}