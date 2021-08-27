package za.ac.cput.service.curriculum.impl;

/*
Dinelle Kotze
219089302
ScheduledClassService.java
This is the service implementation for the ScheduledClass entity.
31 July 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.repository.curriculum.impl.ScheduledClassRepository;
import za.ac.cput.service.curriculum.IScheduledClassService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScheduledClassService implements IScheduledClassService {
    private static IScheduledClassService service = null;

    @Autowired
    private ScheduledClassRepository repository;

    @Override
    public ScheduledClass create(ScheduledClass scheduledClass) { return this.repository.save(scheduledClass); }

    @Override
    public ScheduledClass read(String scheduledClassId) { return this.repository.findById(scheduledClassId).orElse(null); }

    @Override
    public ScheduledClass update(ScheduledClass scheduledClass) {
        if (this.repository.existsById(scheduledClass.getScheduledClassId()))
            return this.repository.save(scheduledClass);
        return null;
    }

    @Override
    public boolean delete(String scheduledClassId) {
        this.repository.deleteById(scheduledClassId);
        if (this.repository.existsById(scheduledClassId))
            return false;
        else
            return true;
    }

    @Override
    public Set<ScheduledClass> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}