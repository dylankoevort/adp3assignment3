package za.ac.cput.repository.curriculum.impl;

/*
Dinelle Kotze
219089302
ScheduledClassRepository.java
This is the class for the ScheduledClassRepository entity.
23 July 2021
 */

import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.repository.curriculum.IScheduledClassRepository;

import java.util.HashSet;
import java.util.Set;

public class ScheduledClassRepository implements IScheduledClassRepository {
    private static ScheduledClassRepository repository = null;
    private Set<ScheduledClass> scheduledClassDb;

    private ScheduledClassRepository() {
        this.scheduledClassDb = new HashSet<>();
    }

    public static ScheduledClassRepository getRepository() {
        if (repository == null) {
            repository = new ScheduledClassRepository();
        }
        return repository;
    }

    @Override
    public ScheduledClass create(ScheduledClass scheduledClass) {
        boolean ok = this.scheduledClassDb.add(scheduledClass);
        if(!ok) {
            return null;
        }
        return scheduledClass;
    }

    public ScheduledClass read(String scheduledClassId) {
        for(ScheduledClass scheduledClass : scheduledClassDb) {
            if(scheduledClass.getScheduledClassId().equalsIgnoreCase(scheduledClassId)) {
                return scheduledClass;
            }
        }
        return null;
    }

    @Override
    public ScheduledClass update(ScheduledClass scheduledClass) {
        ScheduledClass oldExamination = read(scheduledClass.getScheduledClassId());
        if(oldExamination != null) {
            scheduledClassDb.remove(oldExamination);
            scheduledClassDb.add(scheduledClass);
            return scheduledClass;
        }
        return null;
    }

    @Override
    public boolean delete(String scheduledClassId) {
        ScheduledClass scheduledClass = read(scheduledClassId);
        if(scheduledClass != null) {
            this.scheduledClassDb.remove(scheduledClass);
            return true;
        }
        return false;
    }

    @Override
    public Set<ScheduledClass> getAll() {
        return scheduledClassDb;
    }
}
