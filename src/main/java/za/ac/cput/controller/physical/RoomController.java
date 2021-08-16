package za.ac.cput.controller.physical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.entity.physical.Room;
import za.ac.cput.factory.physical.RoomFactory;
import za.ac.cput.service.physical.impl.RoomService;

import java.util.Set;

public class RoomController {

    private RoomService roomService;

    @PostMapping("/createl")
    public Room create(@RequestBody Room room){
        Room r = RoomFactory.build(room.getRoomCode(),room.getRoomType(),room.getRoomCapacity(), room.getBuildingID(), room.getRoomFloor());
        return  roomService.create(r);
    }
    @GetMapping("/readlect")
    public Room read(@PathVariable String id) {
        return roomService.read(id);
    }

    @PostMapping("/updatelect")
    public Room update(@RequestBody Room room) {
        return roomService.update(room);
    }

    @PostMapping("/deletelect")
    public boolean delete(@PathVariable String id) {
        return roomService.delete(id);
    }


    @GetMapping("/getalllect")
    public Set<Room> getAll() {
        return roomService.getAll();
    }
}
