package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * ICourseService.java
 * Service Interface for Course Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 */

public interface ICourseService extends IService<Course, String> {
    Set<Course> getAll();
    Course getcourseCode(String courseCode);
}
