package za.ac.cput.entity.physical;
/**
 * author: Llewelyn Klaase
 * student no: 216267072
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.physical.Building;
import za.ac.cput.factory.physical.BuildingFactory;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @Test
    void test(){
        Building building = BuildingFactory.build("001", 100, "Administration Building", "01 Sesame street, Sesame Town, ABC123");
        System.out.println(building);
        assertNotNull(building);
    }

}