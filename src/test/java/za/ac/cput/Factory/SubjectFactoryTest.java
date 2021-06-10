package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Subject;

import static org.junit.jupiter.api.Assertions.*;
/**
 * SubjectFactoryTest.java
 * TTD for SubjectFactoryTest
 * Author: Shane Knoll (218279124)
 * Date:10 June 2021
 */
class SubjectFactoryTest {

    @Test
    void build() {

        Subject b = SubjectFactory.build(397,"Applications Development 3",8732635,"363",321);
        System.out.print(b);
        assertNotNull(b);
        assertEquals(b,b);

    }
}