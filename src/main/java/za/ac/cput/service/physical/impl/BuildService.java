package za.ac.cput.service.physical.impl;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import za.ac.cput.entity.physical.Building;
import za.ac.cput.repository.physical.impl.BuildingRepository;
import za.ac.cput.service.physical.IBuildingService;

import java.util.Set;

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

    public Building create(Building building) {
        return this.repository.create(building);
    }

    public Building read(String s) {
        return this.repository.read(s);
    }

    public Building update(Building building) {
        return this.repository.update(building);
    }

    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    public Set<Building> getAll() {
        return this.repository.getAll();
    }
}
