package za.ac.cput.service.physical;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.physical.Room;
import za.ac.cput.factory.physical.RoomFactory;
import za.ac.cput.service.physical.impl.RoomService;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {

    private static IRoomService service = RoomService.getService();
    private static Room room = RoomFactory.build("Lecture hall", "123", 100, 2, 1);

    @Test
    void a_create() {
        Room created = service.create(room);
        assertEquals(room.getRoomCode(), created.getRoomCode());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Room read = service.read(room.getRoomCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Room updated = new Room.RoomBuilder().copy(room).setRoomCode("123").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean ok = service.delete(room.getRoomCode());
        assertTrue(ok);
        System.out.println("Delete: " + ok);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }
}