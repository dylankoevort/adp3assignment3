package za.ac.cput.entity.tertiaryInstitution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;

/**
 * CourseTest.java
 * @author Jonathan Kleynhans 217268153
 * 09 June 2021
 */

class DepartmentTest {

    @Test
    void test(){
        Department department = DepartmentFactory.build(420, "Information Technology", " ");
        System.out.println(department);
        assertNotNull(department);
    }
}