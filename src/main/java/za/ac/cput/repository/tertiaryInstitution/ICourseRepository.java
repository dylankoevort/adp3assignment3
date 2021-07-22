package za.ac.cput.repository.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * ICourseRepository.java
 * CourseRepository interface
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 */

public interface ICourseRepository extends IRepository<Course, String> {
    public Set<Course> getAll();
}
