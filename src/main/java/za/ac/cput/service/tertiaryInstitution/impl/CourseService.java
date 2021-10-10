package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.tertiaryInstitution.impl.CourseRepository;
import za.ac.cput.service.tertiaryInstitution.ICourseService;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * CourseService.java
 * Service Implementation of Course Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 * Updated: 28 August 2021
 */

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public Course create(Course course){
        return this.repository.save(course);
    }

    @Override
    public Course read(String x){
        return this.repository.findById(x).orElse(null);
    }

    @Override
    public Course update(Course course) {
        if(this.repository.existsById(course.getcourseCode()))
            return this.repository.save(course);
        return null;
    }

    @Override
    public boolean delete(String courseCode) {
        this.repository.deleteById(courseCode);
        if (this.repository.existsById(courseCode))
            return false;
        else
            return true;
    }

    @Override
    public Set<Course> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Course getcourseCode(String courseCode) {
        Course x = null;
        Set<Course> courses = getAll();
        for(Course course : courses){
            if(course.getcourseCode().equals(courseCode)){
                x = course;
                break;
            }
        }
        return x;
    }
}