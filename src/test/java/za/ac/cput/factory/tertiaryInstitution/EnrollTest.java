package za.ac.cput.entity.tertiaryInstitution;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class EnrollTest {

    @Test
    void test(){
        Date d1 = new Date(2021, Calendar.FEBRUARY, 16);
       Enroll enroll = EnrollFactory.build("OP8989","3988",d1,true);
        System.out.println(enroll);
        assertNotNull(enroll);
    }

}