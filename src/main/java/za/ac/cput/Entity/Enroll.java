package za.ac.cput.Entity;
/**
 * Enroll.java
 * Entity for enroll using builder pattern
 * Author: Tisetso Kotoana
 * Date:01 June 2021
 */
import java.util.Date;
public class Enroll {
    private int studentID;
    private String courseCode;
    private Date date;
    private boolean paymentReceived;

    private Enroll(EnrollBuilder enroll) {
        this.studentID = enroll.studentID;
        this.courseCode = enroll.courseCode;
        this.date = enroll.date;
        this.paymentReceived = enroll.paymentReceived;
    }

    public static class EnrollBuilder{
        private int studentID;
        private String courseCode;
        private Date date;
        private boolean paymentReceived;

        public EnrollBuilder setStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public EnrollBuilder setCourseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public EnrollBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public EnrollBuilder setPaymentReceived(boolean paymentReceived) {
            this.paymentReceived = paymentReceived;
            return this;
        }
        public Enroll build(){

            return new Enroll(this);
        }

        @Override
        public String toString() {
            return "EnrollBuilder{" +
                    "studentID=" + studentID +
                    ", courseCode='" + courseCode + '\'' +
                    ", date=" + date +
                    ", paymentReceived=" + paymentReceived +
                    '}';
        }
    }
}
