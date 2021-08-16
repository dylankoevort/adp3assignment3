package za.ac.cput.service.curriculum.impl;

/*
Dinelle Kotze
219089302
ScheduledClassService.java
This is the service implementation for the ScheduledClass entity.
31 July 2021
 */

import org.springframework.stereotype.Service;
import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.repository.curriculum.IScheduledClassRepository;
import za.ac.cput.repository.curriculum.impl.ScheduledClassRepository;
import za.ac.cput.service.curriculum.IScheduledClassService;

import java.util.Set;

@Service
public class ScheduledClassService implements IScheduledClassService{
    private static IScheduledClassService service = null;
    private IScheduledClassRepository repository;

    private ScheduledClassService() {
        this.repository = ScheduledClassRepository.getRepository();
    }

    public static IScheduledClassService getService(){
        if ( service == null) {
            service = new ScheduledClassService();
        }
        return service;
    }

    @Override
    public ScheduledClass create(ScheduledClass scheduledClass) {
        return this.repository.create(scheduledClass);
    }

    @Override
    public ScheduledClass read(String s) {
        return this.repository.read(s);
    }

    @Override
    public ScheduledClass update(ScheduledClass scheduledClass) {
        return this.repository.update(scheduledClass);
    }

    @Override
    public boolean delete(String scheduledClassId) {
        return this.repository.delete(scheduledClassId);
    }

    @Override
    public Set<ScheduledClass> getAll() {
        return this.repository.getAll();
    }
}