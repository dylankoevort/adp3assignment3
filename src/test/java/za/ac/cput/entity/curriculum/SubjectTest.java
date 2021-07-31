/*
Dinelle Kotze
219089302
SubjectTest.java
This is the test class for the Subject entity.
31 July 2021
 */

package za.ac.cput.entity.curriculum;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.curriculum.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {
    @Test
    void test()
    {
        Subject subject = SubjectFactory.build("PROJECT MANAGEMENT",1,"PRM372S",1);
        System.out.println(subject);
        assertNotNull(subject);
    }
}