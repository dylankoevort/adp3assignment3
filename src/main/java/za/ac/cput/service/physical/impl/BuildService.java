package za.ac.cput.service.physical.impl;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.repository.physical.impl.BuildingRepository;
import za.ac.cput.service.physical.IBuildingService;

import java.util.Set;

@Service
public class BuildService implements IBuildingService {

    private static BuildService Buildservice = null;

    private BuildingRepository repository;

    public BuildService() {
        this.repository = BuildingRepository.getRepository();
    }

    public static BuildService getService(){
        if(Buildservice == null){
            Buildservice = new BuildService();
        }
        return Buildservice;
    }

    @Override
    public Building create(Building building) {
        return this.repository.create(building);
    }

    @Override
    public Building read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Building update(Building building) {
        return this.repository.update(building);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Building> getAll() {
        return this.repository.getAll();
    }
}
