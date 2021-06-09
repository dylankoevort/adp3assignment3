package za.ac.cput.Entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void test() {
        Student s = StudentFactory.build("Dylan", "Koevort","218088159@mycput.ac.za", "0736085710", 21 );
        System.out.println(s);
        assertNotNull(s);
    }

}