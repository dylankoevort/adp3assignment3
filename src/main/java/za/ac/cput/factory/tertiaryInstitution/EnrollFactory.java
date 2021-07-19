package za.ac.cput.factory.tertiaryInstitution;
/**
 * EnrollFactory.java
 * TTD for EnrollFactory
 * Author: Tisetso Kotoana
 * Date:10 June 2021
 */
import za.ac.cput.entity.tertiaryInstitution.Enroll;

import java.util.Date;

public class EnrollFactory {
    public static Enroll.EnrollBuilder build(int studentID, String courseCode, Date date, boolean paymentReceived){

        if(studentID<=0||courseCode.isEmpty() || date.equals("") )
            return null;

        return new Enroll.EnrollBuilder()
                .setStudentID(studentID).setCourseCode(courseCode).setDate(date).setPaymentReceived(paymentReceived);
    }
}
