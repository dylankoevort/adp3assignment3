package za.ac.cput.controller.tertiaryInstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import za.ac.cput.service.tertiaryInstitution.impl.DepartmentService;

import java.util.Set;

/**
 * DepartmentController.java
 * Controller class for Department.
 * @author Jonathan Kleynhans 217268153
 * 13th August 2021
 */

@RestController
@RequestMapping ("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department create (@RequestBody Department department){
        Department newDepartment = DepartmentFactory.build(department.getDepartmentId(), department.getDepartmentName(), department.getDepartmentDesc());
        return departmentService.create(newDepartment);
    }

    @GetMapping("/read/{id}")
    public Department read (@PathVariable String id){
        return departmentService.read(id);
    }

    @PostMapping("/update")
    public Department update (@RequestBody Department department){
        return departmentService.update(department);
    }

    @PostMapping("delete/{id}")
    public boolean delete(@PathVariable String id){
        return departmentService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Department> getAll(){
        return departmentService.getAll();
    }

}
