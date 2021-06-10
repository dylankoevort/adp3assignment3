package za.ac.cput.Factory;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    @Test
    void build(){
        Room build = RoomFactory.build("Theatre", 101,100, 1, 001);
        System.out.println(build);
        assertNotNull(build);
        assertEquals(build, build);
    }

}