package za.ac.cput.service.tertiaryInstitution.impl;
/**
 *
 * SemesterServiceTest.java
 * Test of Enroll Service
 * @author Tisetso Kotoana
 * 30 July 2021
 *
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.factory.tertiaryInstitution.SemesterFactory;
import za.ac.cput.service.tertiaryInstitution.ISemesterService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class SemesterServiceTest {

    private static ISemesterService service = SemesterService.getService();

    private static Date d1 = new Date(121, Calendar.NOVEMBER, 15);
    private static Date d2 = new Date(121, Calendar.NOVEMBER, 15);


    private static Semester semester = SemesterFactory.build("T39090", d1,d2);

    @Test
    void a_create() {
        Semester created = service.create(semester);
        assertEquals(semester.getSemesterID(), created.getSemesterID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Semester read = service.read(semester.getSemesterID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }
    /*
    @Test
    void c_update() {
        Semester updated = new Semester.SemesterBuilder().copy(semester).setSemesterID("20214545").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }
    *
     */

    @Test
    void e_delete() {
        boolean deleted = service.delete(semester.getSemesterID());
        assertTrue(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void d_getAll() {
        System.out.println("Details: \n" + service.getAll());
    }

}