package za.ac.cput.service.tertiaryInstitution.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.repository.tertiaryInstitution.impl.DepartmentRepository;
import za.ac.cput.service.tertiaryInstitution.IDepartmentService;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * CourseService.java
 * Service Implementation of Department Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 * Updated: 28 August 2021
 */

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department create(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department read(String x) {
        return this.repository.findById(x).orElse(null);
    }

    @Override
    public Department update(Department department) {
        return this.repository.save(department);
    }

    @Override
    public boolean delete(String departmentId) {
        this.repository.deleteById(departmentId);
        if (this.repository.existsById(departmentId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Department> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Department getDepartmentId(String departmentId) {
        Department x = null;
        Set<Department> departments = getAll();
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                x = department;
                break;
            }
        }
        return x;
    }
}
