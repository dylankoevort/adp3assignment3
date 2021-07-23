package za.ac.cput.repository.physical;

import za.ac.cput.entity.physical.Room;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRoomRepository extends IRepository<Room, String> {
    public Set<Room> getAll();
}
