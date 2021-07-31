package za.ac.cput.service.curriculum.impl;

/*
Dinelle Kotze
219089302
ScheduledClassServiceTest.java
This is the test class for the ScheduledClassService implementation.
31 July 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.factory.curriculum.ScheduledClassFactory;
import za.ac.cput.service.curriculum.IScheduledClassService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ScheduledClassServiceTest {

    private static IScheduledClassService service = ScheduledClassService.getService();
    private static ScheduledClass scheduledClass = ScheduledClassFactory.build("AB123", 123, 123, 123, "10:00");

    @Test
    void a_create() {
        ScheduledClass created = service.create(scheduledClass);
        assertEquals(scheduledClass.getScheduledClassId(), created.getScheduledClassId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        ScheduledClass read = service.read(scheduledClass.getScheduledClassId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        ScheduledClass updated = new ScheduledClass.Builder().copy(scheduledClass).setClassTime("10:00").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = service.delete(scheduledClass.getScheduledClassId());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }

}