package za.ac.cput.repository.tertiaryInstitution.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.repository.tertiaryInstitution.ICourseRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * CourseRepository.java
 * Implementation of ICourseRepository by CourseRepository
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
}

//
//public class CourseRepository implements ICourseRepository {
//    private static CourseRepository repository = null;
//    private Set<Course> courseDB;
//
//    private CourseRepository(){
//        courseDB = new HashSet<Course>();
//    }
//
//    public static CourseRepository getRepository(){
//        if (repository == null){
//            repository = new CourseRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Course create(Course course) {
//        boolean successful = this.courseDB.add(course);
//        if (!successful){
//            return null;
//        }
//        return course;
//    }
//
//    @Override
//    public Course read(String courseCode) {
//        for(Course course : courseDB){
//            if(course.getcourseCode().equalsIgnoreCase(courseCode)){
//                return course;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Course update(Course course) {
//        Course previousCourse = read(course.getcourseCode());
//        if(previousCourse != null){
//            courseDB.remove(previousCourse);
//            courseDB.add(course);
//            return course;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String courseCode) {
//        Course course = read(courseCode);
//        if(course != null){
//            this.courseDB.remove(course);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Course> getAll() {
//        return courseDB;
//    }
//}
