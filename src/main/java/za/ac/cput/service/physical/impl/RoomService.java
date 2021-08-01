package za.ac.cput.service.physical.impl;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import za.ac.cput.entity.physical.Room;
import za.ac.cput.repository.physical.impl.RoomRepository;
import za.ac.cput.service.physical.IRoomService;

import java.util.Set;

public class RoomService implements IRoomService {

    private static RoomService Roomservice = null;
    private RoomRepository repository;

    public RoomService() {
        this.repository = RoomRepository.getRepository();
    }

    public static RoomService getService(){
        if(Roomservice == null){
            Roomservice = new RoomService();
        }
        return Roomservice;
    }

    public Room create(Room room) {
        return this.repository.create(room);
    }

    public Room read(String s) {
        return this.repository.read(s);
    }

    public Room update(Room room) {
        return this.repository.update(room);
    }

    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    public Set<Room> getAll() {
        return this.repository.getAll();
    }
}
