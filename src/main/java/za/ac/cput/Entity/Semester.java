package za.ac.cput.Entity;

import java.util.Date;

/**
 * Enroll.java
 * Entity for semester using builder pattern
 * Author: Tisetso Kotoana
 * Date:01 June 2021
 */
public class Semester {
   private int semesterID;
   private Date semesterStart;
   private Date semesterEnd;

   public Semester(SemesterBuilder Y) {
      this.semesterID = semesterID;
      this.semesterStart = semesterStart;
      this.semesterEnd = semesterEnd;
   }

   public static class SemesterBuilder{
      private int semesterID;
      private Date semesterStart;
      private Date semesterEnd;

      public SemesterBuilder setSemesterID(int semesterID) {
         this.semesterID = semesterID;
         return this;
      }

      public SemesterBuilder setSemesterStart(Date semesterStart) {
         this.semesterStart = semesterStart;
         return this;
      }

      public SemesterBuilder setSemesterEnd(Date semesterEnd) {
         this.semesterEnd = semesterEnd;
         return this;
      }

      public Semester build(){

         return new Semester(this);
      }

      @Override
      public String toString() {
         return "SemesterBuilder{" +
                 "semesterID=" + semesterID +
                 ", semesterStart=" + semesterStart +
                 ", semesterEnd=" + semesterEnd +
                 '}';
      }
   }
}
