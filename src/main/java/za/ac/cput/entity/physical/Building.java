package za.ac.cput.entity.physical;

/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

public class Building {

    private int buildingID, roomCount;
    private String buildingName, buildingAddress;

    public Building(BuildingBuilder building) {
        this.buildingID = building.buildingID;
        this.buildingName = building.buildingName;
        this.buildingAddress = building.buildingAddress;
        this.roomCount = building.roomCount;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingID=" + buildingID +
                ", roomCount=" + roomCount +
                ", buildingName='" + buildingName + '\'' +
                ", buildingAddress='" + buildingAddress + '\'' +
                '}';
    }

    public static class BuildingBuilder {
        private int buildingID, roomCount;
        private String buildingName, buildingAddress;

        public BuildingBuilder setBuildingID(int buildingID) {
            this.buildingID = buildingID;
            return this;
        }

        public BuildingBuilder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public BuildingBuilder setRoomCount(int roomCount) {
            this.roomCount = roomCount;
            return this;
        }

        public BuildingBuilder setBuildingAddress(String buildingAddress) {
            this.buildingAddress = buildingAddress;
            return this;
        }

        public Building build() { return new Building(this); }

        public BuildingBuilder copy (Building building) {
            this.buildingID = building.buildingID;
            this.buildingName = building.buildingName;
            this.roomCount = building.roomCount;
            this.buildingAddress = building.buildingAddress;

            return this;
        }
    }
}
