package za.ac.cput.repository.curriculum;

/*
Dinelle Kotze
219089302
ScheduledClassRepository.java
This is the interface for the ScheduledClassRepository entity.
23 July 2021
 */

import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Deprecated
public interface IScheduledClassRepository extends IRepository<ScheduledClass, String> {
    Set<ScheduledClass> getAll();
}
