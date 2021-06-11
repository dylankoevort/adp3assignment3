package za.ac.cput.Factory;
import za.ac.cput.Entity.Semester;

import java.util.Date;
/**
 * SemesterFactory.java
 * TTD for SemesterFactory
 * Author: Tisetso Kotoana
 * Date:10 June 2021
 */

public class SemesterFactory {
   public static Semester.SemesterBuilder build(int semesterID, Date semesterStart, Date semesterEnd){
       if(semesterID<=0||semesterStart.equals("")  || semesterEnd.equals(""))
           return null;

       return new Semester.SemesterBuilder()
               .setSemesterID(semesterID).setSemesterStart(semesterStart).setSemesterEnd(semesterEnd);
   }
}
