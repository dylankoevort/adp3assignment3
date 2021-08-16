package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.tertiaryInstitution.ICourseRepository;
import za.ac.cput.repository.tertiaryInstitution.impl.CourseRepository;
import za.ac.cput.service.tertiaryInstitution.ICourseService;

import java.util.Set;

/**
 * CourseService.java
 * Service Implementation of Course Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 */

@Service
public class CourseService implements ICourseService {
    private static ICourseService service = null;
    private ICourseRepository repository;

    private CourseService(){
        this.repository = CourseRepository.getRepository();
    }

    public static ICourseService getService(){
        if(service == null){
            service = new CourseService();
        }
        return service;
    }

    @Override
    public Course create(Course course){
        return this.repository.create(course);
    }

    @Override
    public Course read(String x){
        return this.repository.read(x);
    }

    @Override
    public Course update(Course course) {
        return this.repository.update(course);
    }

    @Override
    public boolean delete(String courseCode) {
        return this.repository.delete(courseCode);
    }

    @Override
    public Set<Course> getAll() {
        return this.repository.getAll();
    }
}