package za.ac.cput.repository.tertiaryInstitution;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;
import za.ac.cput.repository.tertiaryInstitution.impl.EnrollRepository;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)

class EnrollRepositoryTest {

    private static EnrollRepository repository = EnrollRepository.getRepository();
    private static Date d1 = new Date(2021, Calendar.FEBRUARY, 13);

    private static Enroll enroll = EnrollFactory.build("2021ICT", "ADP2021",d1,true );

    @Test
    void a_create(){
        Enroll initialized = repository.create(enroll);
        assertEquals(enroll.getStudentID(), initialized.getStudentID());
        System.out.println("Enrolled " + initialized);
    }

    @Test
    void b_read(){
        Enroll read = repository.read(enroll.getStudentID());
        assertNotNull(read);
        System.out.println("Results: " + read);
    }

    @Test
    void c_update(){
        Enroll updated = new Enroll.EnrollBuilder().copy(enroll).setCourseCode("2021UHP").build();
       assertNotNull(repository.update(updated));
        System.out.println("Update done: " + updated);
    }

    @Test
    void e_delete(){
       boolean check = repository.delete(enroll.getStudentID());
       assertTrue(check);
       System.out.println("Deletion done: " + check);
    }

    @Test
    void d_getAll(){

       System.out.println("Full Details: \n" + repository.getAll());
    }
}