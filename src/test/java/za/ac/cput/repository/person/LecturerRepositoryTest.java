package za.ac.cput.repository.person;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.person.Lecturer;
import za.ac.cput.factory.person.LecturerFactory;
import za.ac.cput.repository.curriculum.impl.SubjectRepository;
import za.ac.cput.repository.person.impl.LecturerRepository;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Created LecturerRepositoryTest
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LecturerRepositoryTest {

    private  static  LecturerRepository repository = LecturerRepository.getRepository();
    private static Lecturer lecturer = LecturerFactory.build("Max", "white", 43, "maxwhite@gmail.com", "0785556432");

    @Test
    @Order(1)
    void Lect_create() {
        Lecturer createdLecturer = repository.create(lecturer);
        assertEquals(createdLecturer.getLecturerID(),lecturer.getLecturerID());
        assertSame(createdLecturer.getLecturerID(),lecturer.getLecturerID());
        System.out.println("Created Lecturer: "+ createdLecturer);

    }

    @Test
    @Order(2)
    void Lect_read(){

        Lecturer le = repository.read(lecturer.getLecturerID());
        assertEquals(le.getLecturerID(),lecturer.getLecturerID());
        assertSame(le.getLecturerID(),lecturer.getLecturerID());
        System.out.println("Reading Lecturer:"+ le);


    }


    @Test
    @Order(3)
    void Lect_update(){

        Lecturer updated = new Lecturer.LecturerBuilder().copy(lecturer).setage(25).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated new age of :"+ updated);

    }


    @Test
    @Order(4)
    void Lect_delete(){

        boolean l = repository.delete(lecturer.getLecturerID());
        assertTrue(l);
        System.out.println("Did the delete work: " + l);

    }

    @Test
    @Order(5)
    void Lect_getAll() {
        System.out.println("displaying all information: " + repository.getAll());
    }



}