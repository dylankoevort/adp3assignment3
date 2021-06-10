package za.ac.cput.Factory;

import za.ac.cput.Entity.ScheduledClass;

/**
 * Dinelle Kotze
 * 219089302
 * ScheduledClassFactory.java
 * This is the factory class for the ScheduledClass entity.
 */

public class ScheduledClassFactory
{
    public static ScheduledClass build (int classCode, int subjectCode, int roomCode, String classTime)
    {
        if (classCode <= 0 || subjectCode <= 0 || roomCode <= 0 || classTime.isEmpty())
        {
            return null;
        }

        return new ScheduledClass.Builder()
                .setClassCode(classCode)
                .setSubjectCode(subjectCode)
                .setRoomCode(roomCode)
                .setClassTime(classTime)
                .build();
    }
}
