package za.ac.cput.repository.physical.impl;

/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import za.ac.cput.entity.physical.Building;

import java.util.HashSet;
import java.util.Set;

public class BuildingRepository implements IBuildingRepository{

    private static BuildingRepository Buildingrepository = null;
    private Set<Building> BuildingDB = null;

    private BuildingRepository(){

        BuildingDB = new HashSet<>();
    }

    public static BuildingRepository getRepository(){

        if(Buildingrepository == null){
            Buildingrepository = new BuildingRepository();
        }
        return Buildingrepository;
    }

    public Building create(Building building){
        boolean success = BuildingDB.add(building);
        if(!success)
            return null;
        return building;
    }

    public Building read(String BuildingID){

        for(Building b: BuildingDB) {
            if(b.getBuildingID().equals(BuildingID)){
                return b;
            }
        }
        return null;
    }

    public Building update(Building b){
        Building build = read(b.getBuildingID());
        if(build!=null){
            BuildingDB.remove(build);
            BuildingDB.add(b);
            return b;

        }
        return null;
    }

    public boolean delete(String BuildingID){
        Building delete = read(BuildingID);
        if(delete==null)
            return false;
        BuildingDB.remove(delete);
        return true;

    }

    public Set<Building> getAll() { return BuildingDB;
    }
}
