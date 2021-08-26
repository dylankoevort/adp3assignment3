package za.ac.cput.repository.tertiaryInstitution.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.repository.tertiaryInstitution.IDepartmentRepository;
import java.util.HashSet;
import java.util.Set;

/**
 * DepartmentRepository.java
 * Implementation of IDepartmentRepository by DepartmentRepository
 * @author Jonathan Kleynhans 217268153
 * 22 July 2021
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}

//public class DepartmentRepository implements IDepartmentRepository {
//    private static DepartmentRepository repository = null;
//    private Set<Department> departmentDB;
//
//    private DepartmentRepository(){
//        departmentDB = new HashSet<Department>();
//    }
//
//    public static DepartmentRepository getRepository(){
//        if(repository == null){
//            repository = new DepartmentRepository();
//        }
//        return repository;
//    }
//
//    @Override
//    public Department create(Department department) {
//        boolean successful = this.departmentDB.add(department);
//        if (!successful){
//            return null;
//        }
//        return department;
//    }
//
//    @Override
//    public Department read(String departmentId) {
//        for(Department department : departmentDB){
//            if(department.getDepartmentId().equalsIgnoreCase(departmentId)){
//                return department;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Department update(Department department) {
//        Department previousDepartment = read(department.getDepartmentId());
//        if(previousDepartment != null){
//            departmentDB.remove(previousDepartment);
//            departmentDB.add(department);
//            return department;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String departmentId) {
//        Department department = read(departmentId);
//        if(department != null){
//            this.departmentDB.remove(department);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Department> getAll() {
//        return departmentDB;
//    }
//}
