package za.ac.cput.Factory;
/**
 * EnrollFactory.java
 * TTD for EnrollFactory
 * Author: Tisetso Kotoana
 * Date:10 June 2021
 */
import za.ac.cput.Entity.Enroll;
import java.lang.Boolean;

import java.util.Date;

public class EnrollFactory {
    public static Enroll.EnrollBuilder build(int studentID, String courseCode, Date date, boolean paymentReceived){

        if(studentID<=0||courseCode.isEmpty() || date.equals("") )
            return null;

        return new Enroll.EnrollBuilder()
                .setStudentID(studentID).setCourseCode(courseCode).setDate(date).setPaymentReceived(paymentReceived);
    }
}
