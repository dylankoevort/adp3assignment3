package za.ac.cput.controller.tertiaryInstitution;
/**
 * EnrollController.java
 * TTD for EnrollController
 * Autho Tisetso Kotoana
 * Date:15 June 2021
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.factory.tertiaryInstitution.SemesterFactory;
import za.ac.cput.service.tertiaryInstitution.impl.SemesterService;

import java.util.Set;

@RestController
@RequestMapping
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @PostMapping("/create")
    public Semester create(@RequestBody Semester semester){
        Semester newSemester =  SemesterFactory.build(semester.getSemesterID(), semester.getSemesterStart(),semester.getSemesterEnd());
        return semesterService.create(newSemester);
    }
    @RequestMapping("/read{xy}")
        public Semester read(@PathVariable String xy){
        return semesterService.read(xy);
    }
    @PostMapping("/update{xy}")
    public Semester update(@RequestBody Semester semester){
        return semesterService.update(semester);

    }
    @PostMapping("/delete{xy}")
    public boolean delete(@RequestBody String xy){
        return semesterService.delete(xy);
    }
    @GetMapping("/getall")
    public Set<Semester> getAll(){
        return semesterService.getAll();
    }
}
