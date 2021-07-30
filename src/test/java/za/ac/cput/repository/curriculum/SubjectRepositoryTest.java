package za.ac.cput.repository.curriculum;

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
    private static Subject subject= SubjectFactory.build("Applications Development 3",7735635,"372",321);
    @Test
    @Order(1)
    void Sub_create() {
        Subject createdSubject = Subjectrepository.create(subject);
        assertEquals(createdSubject.getSubjectCode(),subject.getSubjectCode());
        assertSame(createdSubject.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Created subject:"+ createdSubject);

    }
    // this is the fail test for the Sub_create:
    @Test
    void Sub_createFail(){};

    @Test
    @Order(2)
    void Sub_read() {
        Subject s = Subjectrepository.read(subject.getSubjectCode());
        assertEquals(s.getSubjectCode(),subject.getSubjectCode());
        assertSame(s.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Reading Subject:"+ s);


    }
    // this is the fail test for the Sub_read:
    @Test
    void Sub_readFail(){};

    @Test
    @Order(3)
    void Sub_update() {
        Subject updated = new Subject.SubjectBuilder().copy(subject).setsemesterID(123).build();
        assertNotNull(Subjectrepository.update(updated));
        System.out.println("Updated new semesterID of :"+ updated);
    }
    // this is the fail test for the Sub_update:
    @Test
    void Sub_updateFail(){};

    @Test
    @Order(4)
    void Sub_delete() {
        boolean s= Subjectrepository.delete(subject.getSubjectCode());
        assertTrue(s);
        System.out.println("Did the delete work:"  + s);

    }
    // this is the fail test for the Sub_delete:
    @Test
    void Sub_deleteFail(){};
    @Test
    @Order(5)
    void Sub_getAll() {
        System.out.println("displaying all information: " + Subjectrepository.getAll());
    }
    // this is the fail test for the Sub_getAll:
    @Test
    void Sub_getAllFail(){};
}