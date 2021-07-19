package za.ac.cput.entity.curriculum;

/**
 *
 * ExaminationTest.java
 * Test case for Examination entity
 * @author Dylan Koevort 218088159
 * 9 June 2021
 *
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.factory.curriculum.ExaminationFactory;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExaminationTest {

    Date date = new Date(121, Calendar.JUNE, 14);

    @Test
    void test() {
        Examination exam = ExaminationFactory.build( 10012, "Mathematics", date);
        System.out.println(exam);
        assertNotNull(exam);
    }

}