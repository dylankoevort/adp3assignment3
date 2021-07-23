package za.ac.cput.repository.physical;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.factory.physical.BuildingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BuildingRepositoryTest {
    private static BuildingRepository repository = BuildingRepository.getRepository();
    private static Building building = BuildingFactory.build("666", 41, "Engineering", "1 Plein street");

    @Test
    void a_create() {
        Building created = repository.create(building);
        assertEquals(building.getBuildingID(), created.getBuildingID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Building read = repository.read(building.getBuildingID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Building updated = new Building.BuildingBuilder().copy(building).setBuildingID("666").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = repository.delete(building.getBuildingID());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + repository.getAll());
    }
}