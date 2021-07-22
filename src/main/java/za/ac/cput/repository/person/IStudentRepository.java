package za.ac.cput.repository.person;

/**
 *
 * IStudentRepository.java
 * StudentRepository interface
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 */

import za.ac.cput.entity.person.Student;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String> {
    public Set<Student> getAll();
}
