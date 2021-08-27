/*
package za.ac.cput.repository.curriculum;

*/
/*
Dinelle Kotze
219089302
ScheduledClassRepositoryTest.java
This is the test class for the ScheduledClassRepository entity.
23 July 2021
 */
/*


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.factory.curriculum.ScheduledClassFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ScheduledClassRepositoryTest {
    private static ScheduledClassRepository repository = ScheduledClassRepository.getRepository();
    private static ScheduledClass scheduledClass = ScheduledClassFactory.build("AD11", 112, 122, "10:15");

    @Test
    void a_create() {
        ScheduledClass created = repository.create(scheduledClass);
        assertEquals(scheduledClass.getScheduledClassId(), created.getScheduledClassId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        ScheduledClass read = repository.read(scheduledClass.getScheduledClassId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ScheduledClass updated = new ScheduledClass.Builder().copy(scheduledClass).setSubjectCode(10777).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = repository.delete(scheduledClass.getScheduledClassId());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + repository.getAll());
    }
}*/
