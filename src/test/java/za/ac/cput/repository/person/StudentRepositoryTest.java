package za.ac.cput.repository.person;

/**
 *
 * StudentRepositoryTest.java
 * Test cases for Student Repository implementation
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 *
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.person.Student;
import za.ac.cput.factory.person.StudentFactory;
import za.ac.cput.repository.person.impl.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentRepositoryTest {
    private static StudentRepository repository = StudentRepository.getRepository();
    private static Student student = StudentFactory.build("Dylan", "Koevort","218088159@mycput.ac.za", "0731234567", 21);

    @Test
    void a_create() {
        Student created = repository.create(student);
        assertEquals(student.getStudentId(), created.getStudentId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Student read = repository.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Student updated = new Student.StudentBuilder().copy(student).setAge(31).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = repository.delete(student.getStudentId());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + repository.getAll());
    }
}