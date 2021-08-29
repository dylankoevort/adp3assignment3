package za.ac.cput.repository.tertiaryInstitution.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Course;


/**
 * CourseRepository.java
 * Implementation of ICourseRepository by CourseRepository
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 * Updated: 28 August 2021
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
}
