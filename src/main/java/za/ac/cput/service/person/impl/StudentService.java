package za.ac.cput.service.person.impl;

/**
 *
 * StudentService.java
 * Service Implementation of Student entity
 * @author Dylan Koevort 218088159
 * 27 July 2021
 *
 */

import za.ac.cput.entity.person.Student;
import za.ac.cput.repository.person.IStudentRepository;
import za.ac.cput.repository.person.impl.StudentRepository;
import za.ac.cput.service.person.IStudentService;

import java.util.Set;

public class StudentService implements IStudentService {
    private static IStudentService service = null;
    private IStudentRepository repository;

    private StudentService() {

        this.repository = StudentRepository.getRepository();
    }

    public static IStudentService getService(){
        if ( service == null) {
            service = new StudentService();
        }
        return service;
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public boolean delete(String studentId) {
        return this.repository.delete(studentId);
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }
}
