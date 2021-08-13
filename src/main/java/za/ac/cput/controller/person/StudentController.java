package za.ac.cput.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.person.Student;
import za.ac.cput.factory.person.StudentFactory;
import za.ac.cput.service.person.impl.StudentService;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        Student newStudent = StudentFactory.build(student.getFirstName(), student.getLastName(), student.getEmailAddress(), student.getContactNo(), student.getAge());
        return studentService.create(newStudent);
    }

    @GetMapping("/read/{id}")
    public Student read(@PathVariable String id) {
        return studentService.read(id);
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return studentService.delete(id);
    }


    @GetMapping("/getall")
    public Set<Student> getAll() {
        return studentService.getAll();
    }
}
