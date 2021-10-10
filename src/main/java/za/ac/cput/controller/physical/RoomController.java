package za.ac.cput.controller.physical;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.physical.Room;
import za.ac.cput.factory.physical.RoomFactory;
import za.ac.cput.service.physical.impl.RoomService;

import java.util.Set;

@RestController
@RequestMapping("/room")
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
