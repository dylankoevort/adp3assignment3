package za.ac.cput.service.tertiaryInstitution;
/**
 *
 * IEnrollService.java
 * Implementation of Enroll Service
 * @author Tisetso Kotoana
 * 30 July 2021
 *
 */
import za.ac.cput.entity.person.Student;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IEnrollService extends IService<Enroll, String> {
    Set<Enroll> getAll();
}