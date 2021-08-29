package za.ac.cput.repository.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * IDepartmentRepository.java
 * DepartmentRepository interface
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 */

@Deprecated
public interface IDepartmentRepository extends IRepository<Department, String> {
    Set<Department> getAll();
}
