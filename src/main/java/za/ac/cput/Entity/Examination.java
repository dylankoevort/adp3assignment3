/*
Dinelle Kotze
219089302
Examination.java
This is the class for the Examination entity.
 */

package za.ac.cput.Entity;

import java.util.Date;

public class Examination
{
    private int examID, subjectCode;
    private String examDesc;
    private Date examDate;

    private Examination(Builder builder)
    {
        this.examID = builder.examID;
        this.subjectCode = builder.subjectCode;
        this.examDesc = builder.examDesc;
        this.examDate = builder.examDate;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "examID=" + examID + '\'' +
                ", subjectCode=" + subjectCode + '\'' +
                ", examDesc='" + examDesc + '\'' +
                ", examDate=" + examDate + '\'' +
                '}';
    }

    public static class Builder
    {
        private int examID, subjectCode;
        private String examDesc;
        private Date examDate;

        public Builder setExamID(int examID)
        {
            this.examID = examID;
            return this;
        }

        public Builder setSubjectCode(int subjectCode)
        {
            this.subjectCode = subjectCode;
            return this;
        }


        public Builder setExamDesc(String examDesc)
        {
            this.examDesc = examDesc;
            return this;
        }

        public Builder setExamDate(Date examDate)
        {
            this.examDate = examDate;
            return this;
        }

        public Examination build()
        {
            return new Examination(this);
        }

        private Builder copy(Examination examination)
        {
            this.examID = examination.examID;
            this.subjectCode = examination.subjectCode;
            this.examDesc = examination.examDesc;
            this.examDate = examination.examDate;
            return this;
        }

    }
}

