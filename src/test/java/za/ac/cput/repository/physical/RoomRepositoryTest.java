package za.ac.cput.repository.physical;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.physical.Room;
import za.ac.cput.factory.physical.RoomFactory;
import za.ac.cput.repository.physical.impl.RoomRepository;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepositoryTest {

    private static RoomRepository repository = RoomRepository.getRepository();
    private static Room room = RoomFactory.build( "A", "666", 100, 2, 1);

    @Test
    void a_create() {
        Room created = repository.create(room);
        assertEquals(room.getRoomCode(), created.getRoomCode());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Room read = repository.read(room.getRoomCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Room updated = new Room.RoomBuilder().copy(room).setRoomCode("666").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = repository.delete(room.getRoomCode());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + repository.getAll());
    }

}