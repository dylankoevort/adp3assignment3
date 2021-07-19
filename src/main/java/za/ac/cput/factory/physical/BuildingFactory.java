package za.ac.cput.factory.physical;

import za.ac.cput.entity.physical.Building;

/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

public class BuildingFactory {

    public static Building build(int buildingID, int roomCount, String buildingName, String buildingAddress) {

        if(buildingID <= 0 || roomCount <= 0 || buildingName.isEmpty() || buildingAddress.isEmpty())
            return null;

        return new Building.BuildingBuilder().setBuildingID(buildingID).setRoomCount(roomCount).setBuildingName(buildingName).setBuildingAddress(buildingAddress).build();
    }
}
