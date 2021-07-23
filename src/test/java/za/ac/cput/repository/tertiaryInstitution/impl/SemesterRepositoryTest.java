package za.ac.cput.repository.tertiaryInstitution.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;
import za.ac.cput.factory.tertiaryInstitution.SemesterFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class SemesterRepositoryTest {

    static Date d1 = new Date(2021,02,10);
    static Date d2 = new Date(2021,06,02);
    private static SemesterRepository repository = SemesterRepository.getRepository();
 
    private static Semester semester = SemesterFactory.build("2021ICT", "2021/02/01","2021/06/01",true );

    @Test
    void a_create(){
        Semester initialized = repository.create(semester);
        assertEquals(semester.getSemesterID(), initialized.getSemesterID());
        System.out.println("Created: " + initialized);
    }

    @Test
    void b_read(){
        Semester read = repository.read(semester.getSemesterID());
        assertNotNull(read);
        System.out.println("Results: " + read);
    }

    @Test
    void c_update(){
        Semester updated = new Semester.SemesterBuilder().copy(semester).setSemesterID("2021UHP").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update done: " + updated);
    }

    @Test
    void e_delete(){
        boolean check = repository.delete(semester.getSemesterID());
        assertTrue(check);
        System.out.println("Deletion done: " + check);
    }

    @Test
    void d_getAll(){

        System.out.println("Full Details: \n" + repository.getAll());
    }
}