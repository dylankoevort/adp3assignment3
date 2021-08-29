package za.ac.cput.service.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * IDepartmentService.java
 * Service Interface for Department Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 * Updated: 28 August 2021
 */

public interface IDepartmentService extends IService<Department, String> {
    public Set<Department> getAll();
    public Department getDepartmentId(String departmentId);
}
