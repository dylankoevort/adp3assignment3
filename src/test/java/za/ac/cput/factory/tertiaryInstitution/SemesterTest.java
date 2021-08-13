package za.ac.cput.entity.tertiaryInstitution;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;
import za.ac.cput.factory.tertiaryInstitution.SemesterFactory;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SemesterTest {

    @Test
    void test(){
        Date d1 = new Date(2021, Calendar.FEBRUARY, 07);
        Date d2 = new Date(2021, Calendar.SEPTEMBER, 16);
        Semester semester = SemesterFactory.build("OP8989",d1,d2);
        System.out.println(semester);
        assertNotNull(semester);
    }

}