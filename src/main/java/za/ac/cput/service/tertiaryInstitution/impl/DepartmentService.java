package za.ac.cput.service.tertiaryInstitution.impl;

import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.repository.tertiaryInstitution.IDepartmentRepository;
import za.ac.cput.repository.tertiaryInstitution.impl.DepartmentRepository;
import za.ac.cput.service.tertiaryInstitution.IDepartmentService;

import java.util.Set;

/**
 * CourseService.java
 * Service Implementation of Department Entity
 * @author Jonathan Kleynhans 217268153
 * 30 July 2021
 */

public class DepartmentService implements IDepartmentService {
    private static IDepartmentService service = null;
    private IDepartmentRepository repository;

    private DepartmentService(){
        this.repository = DepartmentRepository.getRepository();
    }

    public static IDepartmentService getService(){
        if(service == null){
            service = new DepartmentService();
        }
        return service;
    }

    @Override
    public Department create(Department department) {
        return this.repository.create(department);
    }

    @Override
    public Department read(String x) {
        return this.repository.read(x);
    }

    @Override
    public Department update(Department department) {
        return this.repository.update(department);
    }

    @Override
    public boolean delete(String departmentId) {
        return this.repository.delete(departmentId);
    }

    @Override
    public Set<Department> getAll() {
        return this.repository.getAll();
    }
}
