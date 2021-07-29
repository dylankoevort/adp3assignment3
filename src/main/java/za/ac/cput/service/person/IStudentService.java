package za.ac.cput.service.person;

/**
 *
 * IStudentService.java
 *  Service Interface for Student entity
 * @author Dylan Koevort 218088159
 * 27 July 2021
 *
 */

import za.ac.cput.entity.person.Student;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IStudentService extends IService <Student, String> {
    Set<Student> getAll();
}
