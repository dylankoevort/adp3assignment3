package za.ac.cput.repository.physical;

import za.ac.cput.entity.physical.Room;

import java.util.HashSet;
import java.util.Set;

public class RoomRepository implements IRoomRepository {

    private static RoomRepository Roomrepository = null;
    private Set<Room> RoomDB = null;

    private RoomRepository(){
        RoomDB = new HashSet<>();
    }

    public static RoomRepository getRepository() {
        if(Roomrepository == null){
            Roomrepository = new RoomRepository();
        }
        return Roomrepository;
    }

    public Room create(Room room){
        boolean success = RoomDB.add(room);
        if(!success)
            return null;
        return room;
    }

    public Room read(String RoomCode){

        for(Room r: RoomDB) {
            if(r.getRoomCode().equals(RoomCode)){
                return r;
            }
        }
        return null;
    }

    public Room update(Room r){
        Room room = read(r.getRoomCode());
        if(room!=null){
            RoomDB.remove(room);
            RoomDB.add(r);
            return r;

        }
        return null;
    }

    public boolean delete(String RoomCode){
        Room delete = read(RoomCode);
        if(delete==null)
            return false;
        RoomDB.remove(delete);
        return true;

    }

    public Set<Room> getAll() { return RoomDB;
    }

}
