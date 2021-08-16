package za.ac.cput.controller.physical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.factory.physical.BuildingFactory;
import za.ac.cput.service.physical.impl.BuildService;

import java.util.Set;

public class BuildingController {

    private BuildService buildingService;

    @PostMapping("/createl")
    public Building create(@RequestBody Building building){
        Building b = BuildingFactory.build(building.getBuildingID(), building.getRoomCount(), building.getBuildingAddress(), building.getBuildingName());
        return buildingService.create(b);
    }
    @GetMapping("/readlect")
    public Building read(@PathVariable String id) {
        return buildingService.read(id);
    }

    @PostMapping("/updatelect")
    public Building update(@RequestBody Building building) {
        return buildingService.update(building);
    }

    @PostMapping("/deletelect")
    public boolean delete(@PathVariable String id) {
        return buildingService.delete(id);
    }


    @GetMapping("/getalllect")
    public Set<Building> getAll() {
        return buildingService.getAll();
    }
}
