package za.ac.cput.service.tertiaryInstitution;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.service.tertiaryInstitution.impl.DepartmentService;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService service;
    private static Department department = DepartmentFactory.build("021", "PROJECTS"," ");

    @Disabled("Not needed.")
    @BeforeAll
    static void setUp(){}

    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @AfterAll
    static void tearDown(){}

    @Test
    void a_create() {
        Department created = service.create(department);
        assertEquals(department.getDepartmentId(), created.getDepartmentId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Department read = service.read(department.getDepartmentId());
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
        boolean x = service.delete(department.getDepartmentId());
        assertTrue(x);
        System.out.println("Deleted: " + x);
    }

    @Test
    void d_getAll() {
        System.out.println("Display all: " + service.getAll());
    }
}