package za.ac.cput.repository.curriculum.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.entity.curriculum.Subject;
import za.ac.cput.factory.curriculum.SubjectFactory;
import za.ac.cput.repository.curriculum.impl.SubjectRepository;

/**
 *
 * Created SubjectRepositoryTest
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubjectRepositoryTest {

    private  static SubjectRepository Subjectrepository = SubjectRepository.getRepository();
    private static Subject subject= SubjectFactory.build("Applications Development 3",8732635,"363",321);
    @Test
    @Order(1)
    void Sub_create() {
        Subject createdSubject = Subjectrepository.create(subject);
        assertEquals(createdSubject.getSubjectCode(),subject.getSubjectCode());
        assertSame(createdSubject.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Created subject:"+ createdSubject);

    }

    @Test
    @Order(2)
    void Sub_read() {
        Subject s = Subjectrepository.read(subject.getSubjectCode());
        assertEquals(subject.getSubjectCode(),subject.getSubjectCode());
        assertSame(subject.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Reading Subject:"+ s);


    }

    @Test
    @Order(3)
    void Sub_update() {
        Subject updated = new Subject.SubjectBuilder().copy(subject).setsemesterID(123).build();
        assertNotNull(Subjectrepository.update(updated));
        System.out.println("Updated new semesterID of :"+ updated);
    }

    @Test
    @Order(4)
    void Sub_delete() {
        boolean s= Subjectrepository.delete(subject.getSubjectCode());
        assertTrue(s);
        System.out.println("Did the delete work:"  + s);

    }
    @Test
    @Order(5)
    void Sub_getAll() {
        System.out.println("displaying all information: " + SubjectRepository.getRepository().getAll());
    }
}