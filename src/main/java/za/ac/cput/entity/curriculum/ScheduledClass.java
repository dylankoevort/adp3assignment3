/*
Dinelle Kotze
219089302
ScheduledClass.java
This is the class for the ScheduledClass entity.
 */

package za.ac.cput.entity.curriculum;

public class ScheduledClass
{
    private int classCode, subjectCode, roomCode;
    private String classTime;

    private ScheduledClass(Builder builder)
    {
        this.classCode = builder.classCode;
        this.subjectCode = builder.subjectCode;
        this.roomCode = builder.roomCode;
        this.classTime = builder.classTime;
    }

    @Override
    public String toString() {
        return "ScheduledClass{" +
                "classCode=" + classCode + '\'' +
                ", subjectCode=" + subjectCode + '\'' +
                ", roomCode='" + roomCode + '\'' +
                ", classTime=" + classTime + '\'' +
                '}';
    }

    public static class Builder
    {
        private int classCode, subjectCode, roomCode;
        private String classTime;

        public Builder setClassCode(int classCode)
        {
            this.classCode = classCode;
            return this;
        }

        public Builder setSubjectCode(int subjectCode)
        {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setRoomCode(int roomCode)
        {
            this.roomCode = roomCode;
            return this;
        }

        public Builder setClassTime(String classTime)
        {
            this.classTime = classTime;
            return this;
        }

        public ScheduledClass build()
        {
            return new ScheduledClass(this);
        }

        private Builder copy(ScheduledClass scheduledClass)
        {
            this.classCode = scheduledClass.classCode;
            this.subjectCode = scheduledClass.subjectCode;
            this.roomCode = scheduledClass.roomCode;
            this.classTime = scheduledClass.classTime;
            return this;
        }

    }
}

