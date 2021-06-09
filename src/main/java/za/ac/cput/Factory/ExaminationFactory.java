package za.ac.cput.Factory;

/**
 *
 * ExaminationFactory.java
 * Factory class for Examination entity
 * @author Dylan Koevort 218088159
 * 9 June 2021
 *
 */

import za.ac.cput.Entity.Examination;

import java.util.Date;

public class ExaminationFactory {

    public static Examination build(int examId, int subjectCode, String examDesc, Date examDate) {

        if(examId <= 0 || subjectCode <= 0 || examDesc.isEmpty() || examDate == null) {
            return null;
        }

        return new Examination.Builder()
                .setExamID(examId)
                .setSubjectCode(subjectCode)
                .setExamDesc(examDesc)
                .setExamDate(examDate)
                .build();
    }
}
