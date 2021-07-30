package za.ac.cput.service.curriculum;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.curriculum.Subject;
import za.ac.cput.factory.curriculum.SubjectFactory;
import za.ac.cput.service.curriculum.impl.SubjectService;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * Created SubjectServiceTest
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubjectServiceTest {

    private static ISubjectService Subjectservice = SubjectService.getService();
    private static Subject subject= SubjectFactory.build("Applications Development 3",8732635,"363",321);
    @Test
    @Order(1)
    void Sub_create() {
        Subject createdSubject = Subjectservice.create(subject);
        assertEquals(createdSubject.getSubjectCode(),subject.getSubjectCode());
        assertSame(createdSubject.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Created subject:"+ createdSubject);

    }

    @Test
    @Order(2)
    void Sub_read() {
        Subject s = Subjectservice.read(subject.getSubjectCode());
        assertEquals(s.getSubjectCode(),subject.getSubjectCode());
        assertSame(s.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Reading Subject:"+ s);


    }

    @Test
    @Order(3)
    void Sub_update() {
        Subject updated = new Subject.SubjectBuilder().copy(subject).setsemesterID(123).build();
        assertNotNull(Subjectservice.update(updated));
        System.out.println("Updated new semesterID of :"+ updated);
    }

    @Test
    @Order(4)
    void Sub_delete() {
        boolean subje= Subjectservice.delete(subject.getSubjectCode());
        assertTrue(subje);
        System.out.println("Deleted the following:"  + subje);

    }
    @Test
    @Order(5)
    void Sub_getAll() {
        System.out.println("displaying all information: " + Subjectservice.getAll());
    }


}