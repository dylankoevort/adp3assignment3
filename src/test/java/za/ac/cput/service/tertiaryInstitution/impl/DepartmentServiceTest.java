package za.ac.cput.service.tertiaryInstitution.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import za.ac.cput.service.tertiaryInstitution.IDepartmentService;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DepartmentServiceTest {
    private static IDepartmentService service = DepartmentService.getService();
    private static Department department = DepartmentFactory.build("021", "PROJECTS"," ");

    @Disabled("Not needed.")
    @BeforeAll
    static void setUp(){}

    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @AfterAll
    static void tearDown(){}

    @Test
    void testIdentity(){}

    @Test
    void a_create() {
        Department created = service.create(department);
        assertEquals(department.getdepartmentId(), created.getdepartmentId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Department read = service.read(department.getdepartmentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Department update = new Department.DepartmentBuilder().copy(department).setDepartmentDesc("Test").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean x = service.delete(department.getdepartmentId());
        assertTrue(x);
        System.out.println("Deleted: " + x);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all: " + service.getAll());
    }
}