/*
Dinelle Kotze
219089302
ScheduledClass.java
This is the class for the ScheduledClass entity.
 */

package za.ac.cput.entity.curriculum;

public class ScheduledClass
{
    private int subjectCode, roomCode;
    private String scheduledClassId, classTime;

    private ScheduledClass(Builder builder)
    {
        this.scheduledClassId = builder.scheduledClassId;
        this.subjectCode = builder.subjectCode;
        this.roomCode = builder.roomCode;
        this.classTime = builder.classTime;
    }

    public String getScheduledClassId() {
        return scheduledClassId;
    }

    @Override
    public String toString() {
        return "ScheduledClassRepository{" +
                "scheduledClassId=" + scheduledClassId + '\'' +
                ", subjectCode=" + subjectCode + '\'' +
                ", roomCode='" + roomCode + '\'' +
                ", classTime=" + classTime + '\'' +
                '}';
    }

    public static class Builder
    {
        private int subjectCode, roomCode;
        private String scheduledClassId, classTime;

        public Builder setScheduledClassId(String scheduledClassId)
        {
            this.scheduledClassId = scheduledClassId;
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

        public Builder copy(ScheduledClass scheduledClass)
        {
            this.scheduledClassId = scheduledClass.scheduledClassId;
            this.subjectCode = scheduledClass.subjectCode;
            this.roomCode = scheduledClass.roomCode;
            this.classTime = scheduledClass.classTime;
            return this;
        }

    }
}

