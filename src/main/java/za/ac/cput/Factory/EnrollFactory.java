package za.ac.cput.Factory;

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
