package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Enroll;
import za.ac.cput.Entity.Semester;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
/**
 * SemesterFactoryTest.java
 * TTD for SemesterFactoryTest
 * Author: Tisetso Kotoana
 * Date:10 June 2021
 */

class SemesterFactoryTest {

    @Test
    void Semester() {

        Semester build = SemesterFactory.build(57304,"02/09/21", "01/02/21");
        System.out.print(build);
        assertNotNull(build);
        assertEquals(build,build);


    }
}