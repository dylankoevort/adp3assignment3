package za.ac.cput.repository.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * ISemesterRepository.java
 * DDD for Semester Repository
 * Author: Tisetso Kotoana
 * Date: 23 July 2021
 */
public interface ISemesterRepository extends IRepository<Semester, String> {
    Set<Semester> getAll();
}
