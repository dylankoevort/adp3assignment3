package za.ac.cput.repository.physical;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IBuildingRepository extends IRepository<Building, String> {
    public Set<Building> getAll();
}
