package za.ac.cput.repository.person.impl;

/**
 *
 * StudentRepository.java
 * Implementation of IStudentRepository by StudentRepository
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 * 23 Aug 2021: Refactored to use JpaRepository framework (Dylan Koevort)
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.person.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}