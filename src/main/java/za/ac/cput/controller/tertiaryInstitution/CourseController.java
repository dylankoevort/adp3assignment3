package za.ac.cput.controller.tertiaryInstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
import za.ac.cput.service.tertiaryInstitution.impl.CourseService;

import java.util.Set;

/**
 * CourseController.java
 * Controller class for Course.
 * @author Jonathan Kleynhans 217268153
 * 13th August 2021
 */

@RestController
@RequestMapping ("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public Course create (@RequestBody Course course){
        Course newCourse = CourseFactory.build(course.getcourseCode(), course.getcourseTitle(), course.getdepartmentId(), course.getCredit(), course.getDuration(), course.getFullTime());
        return courseService.create(newCourse);
    }

    @GetMapping("/read/{id}")
    public Course read (@PathVariable String id){
        return courseService.read(id);
    }

    @PostMapping("/update")
    public Course update(@RequestBody Course course){
        return courseService.update(course);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return courseService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Course> getAll() {
        return courseService.getAll();
    }

}
