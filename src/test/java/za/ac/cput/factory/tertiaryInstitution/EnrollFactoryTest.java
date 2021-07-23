package za.ac.cput.factory.tertiaryInstitution;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;

/**
 * EnrollFactoryTest.java
 * TTD for EnrollFactoryTest
 * Author: Tisetso Kotoana
 * Date:10 June 2021
 */
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnrollFactoryTest {

    Date d1 = new Date(2021,06,11);
    @Test
    void Enroll() {
        Date date = new Date();
        Enroll.EnrollBuilder build = EnrollFactory.build("20201ABC","ADP467",d1,true);
        System.out.print(build);
        assertNotNull(build);
        assertEquals(build,build);


    }
}