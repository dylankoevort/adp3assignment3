package za.ac.cput.service.physical;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.factory.physical.BuildingFactory;
import za.ac.cput.service.physical.impl.BuildingService;

import static org.junit.jupiter.api.Assertions.*;

class BuildingServiceTest {

    private static IBuildingService service = BuildingService.getService();
    private static Building building = BuildingFactory.build("123", 100, "Engineering Building", "01 Sesame street");

    @Test
    void a_create() {
        Building created = service.create(building);
        assertEquals(building.getBuildingID(), created.getBuildingID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Building read = service.read(building.getBuildingID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Building updated = new Building.BuildingBuilder().copy(building).setBuildingID("123").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = service.delete(building.getBuildingID());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }
}