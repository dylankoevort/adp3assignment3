package za.ac.cput.service.curriculum;

/*
Dinelle Kotze
219089302
ExaminationServiceTest.java
This is the test class for the ExaminationService implementation.
31 July 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.factory.curriculum.ExaminationFactory;
import za.ac.cput.service.curriculum.IExaminationService;
import za.ac.cput.service.curriculum.impl.ExaminationService;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ExaminationServiceTest {

    private static LocalDate examDate = LocalDate.of(2021, 7, 31);
    private static IExaminationService service = ExaminationService.getService();
    private static Examination examination = ExaminationFactory.build(123, "End year exam", examDate);

    @Test
    void a_create() {
        Examination created = service.create(examination);
        assertEquals(examination.getExamId(), created.getExamId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Examination read = service.read(examination.getExamId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Examination updated = new Examination.Builder().copy(examination).setExamDesc("Main exam of the year").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = service.delete(examination.getExamId());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }

}
