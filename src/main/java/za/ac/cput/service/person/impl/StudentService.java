package za.ac.cput.service.person.impl;

/**
 *
 * StudentService.java
 * Service Implementation of Student entity
 * @author Dylan Koevort 218088159
 * 27 July 2021
 *
 * Updated 23 Aug 2021: Refactored to use JpaRepository framework (Dylan Koevort)
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.person.Student;
import za.ac.cput.repository.person.impl.StudentRepository;
import za.ac.cput.service.person.IStudentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Student update(Student student) {
        if (this.repository.existsById(student.getStudentId()))
            return this.repository.save(student);
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        this.repository.deleteById(studentId);
        if (this.repository.existsById(studentId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Student getStudentGivenLastName(String lastName) {
        Student s = null;
        Set<Student> students = getAll();
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                s = student;
                break;
            }
        }
        return s;
    }
}
