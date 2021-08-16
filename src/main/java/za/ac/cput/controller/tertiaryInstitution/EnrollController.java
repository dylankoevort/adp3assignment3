package za.ac.cput.controller.tertiaryInstitution;
/**
 * SemesterController.java
 * TTD for SemesterController
 * Autho Tisetso Kotoana
 * Date:15 June 2021
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;
import za.ac.cput.service.tertiaryInstitution.impl.EnrollService;

import java.util.Set;

@RestController
@RequestMapping

public class EnrollController {
    @Autowired
    private EnrollService enrollService;

    @PostMapping("/create")

    public Enroll create(@RequestBody Enroll enroll){
        Enroll newEnroller = EnrollFactory.build(enroll.getStudentID(), enroll.getCourseCode(), enroll.getDate(),enroll.getPaymentReceived());
        return enrollService.create(newEnroller);
    }

    @RequestMapping("/read{xy}")
    public Enroll read(@PathVariable String xy){
        return enrollService.read(xy);
    }

    @PostMapping("/update{xy}")
    public Enroll update(@RequestBody Enroll enroll){

        return enrollService.update(enroll);
    }
    @PostMapping("/delete/{xy}")
    public boolean delete(@RequestBody String xy){
        return enrollService.delete(xy);
    }
    @GetMapping("/getall")
    public Set <Enroll> getAll(){
        return enrollService.getAll();
    }

}
