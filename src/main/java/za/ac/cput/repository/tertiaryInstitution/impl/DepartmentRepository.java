package za.ac.cput.repository.tertiaryInstitution.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Department;

/**
 * DepartmentRepository.java
 * Implementation of IDepartmentRepository by DepartmentRepository
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 * Updated: 28 August 2021
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
