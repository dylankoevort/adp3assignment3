package za.ac.cput.service.person;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.person.Lecturer;
import za.ac.cput.factory.person.LecturerFactory;
import za.ac.cput.service.person.impl.LecturerService;


import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * Created LecturerServiceTest
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LecturerServiceTest {

    private static ILecturerService service = LecturerService.getService();
    private static Lecturer lect = LecturerFactory.build("Ben","White",25,"Benwhite@gmail.com","0784455836");

    @Test
    @Order(1)
    void Le_create() {
        Lecturer created = service.create(lect);
        assertEquals(created.getLecturerID(),lect.getLecturerID());
        assertSame(created.getLecturerID(),lect.getLecturerID());
        System.out.println("Created subject:"+ created);
    }

    @Test
    @Order(2)
    void Le_read() {
        Lecturer le =service.read(lect.getLecturerID());
        assertEquals(le.getLecturerID(),lect.getLecturerID());
        assertSame(le.getLecturerID(),lect.getLecturerID());
        System.out.println("Read:"+le);
    }

    @Test
    @Order(3)
    void Le_update() {
        Lecturer updated = new Lecturer.LecturerBuilder().copy(lect).setage(30).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated new age of "+ updated);
    }

    @Test
    @Order(4)
    void Le_delete() {
       boolean de = service.delete(lect.getLecturerID());
        assertTrue(de);
        System.out.println("deleted the following:" + lect.getLecturerID()+" ");
    }


    @Test
    @Order(5)
    void Le_getAll() {

            System.out.println("Displaying all information:" + service.getAll());

    }
}