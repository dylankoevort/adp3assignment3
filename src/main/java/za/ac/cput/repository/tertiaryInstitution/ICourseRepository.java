package za.ac.cput.repository.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * ICourseRepository.java
 * CourseRepository interface
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 * Updated: 28 August 2021
 */

@Deprecated
public interface ICourseRepository extends IRepository<Course, String> {
    Set<Course> getAll();
}
