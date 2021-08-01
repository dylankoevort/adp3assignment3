package za.ac.cput.service.curriculum;

/*
Dinelle Kotze
219089302
IScheduledClassService.java
This is the service interface for the Scheduled Class entity.
31 July 2021
 */

import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IScheduledClassService extends IService<ScheduledClass, String> {
    Set<ScheduledClass> getAll();
}


