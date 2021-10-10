package za.ac.cput.service.physical;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.factory.physical.BuildingFactory;
import za.ac.cput.service.physical.impl.BuildService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class BuildServiceTest {

    private static IBuildingService service = BuildService.getService();
    private static Building building = BuildingFactory.build("123", 100, "Engineering Building", "01 Sesame street");

    @Test
    @Order(1)
    void a_create() {
        Building created = service.create(building);
        assertEquals(building.getBuildingID(), created.getBuildingID());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void b_read() {
        Building read = service.read(building.getBuildingID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void c_update() {
        Building updated = new Building.BuildingBuilder().copy(building).setBuildingID("123").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    void e_delete() {
        boolean ok = service.delete(building.getBuildingID());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    @Order(4)
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }
}