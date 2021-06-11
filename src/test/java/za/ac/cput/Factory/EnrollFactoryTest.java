package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Enroll;
import za.ac.cput.Entity.Lecturer;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EnrollFactoryTest {


    @Test
    void Enroll() {
        Date date = new Date();
        Enroll build = EnrollFactory.build(56443,"ADP467","2021/03/07",true);
        System.out.print(build);
        assertNotNull(build);
        assertEquals(build,build);


    }
}