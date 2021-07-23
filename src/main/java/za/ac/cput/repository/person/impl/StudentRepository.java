package za.ac.cput.repository.person.impl;

/**
 *
 * StudentRepository.java
 * Implementation of IStudentRepository by StudentRepository
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 */

import za.ac.cput.entity.person.Student;
import za.ac.cput.repository.person.IStudentRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository implements IStudentRepository {
    private static StudentRepository repository = null;
    private Set<Student> studentDb;

    private StudentRepository() {
        this.studentDb = new HashSet<Student>();
    }

    public static StudentRepository getRepository() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public Student create(Student student) {
        boolean ok = this.studentDb.add(student);
        if(!ok) {
            return null;
        }
        return student;
    }

    @Override
    public Student read(String studentId) {
        for( Student student : studentDb) {
            if(student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        Student oldStudent = read(student.getStudentId());
        if(oldStudent != null) {
            studentDb.remove(oldStudent);
            studentDb.add(student);
            return student;
        }
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        Student student = read(studentId);
        if(student != null) {
            this.studentDb.remove(student);
            return true;
        }
        return false;
    }

    @Override
    public Set<Student> getAll() {
        return studentDb;
    }
}
