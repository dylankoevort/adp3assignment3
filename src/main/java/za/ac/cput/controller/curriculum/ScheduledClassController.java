package za.ac.cput.controller.curriculum;

/*
Dinelle Kotze
219089302
ScheduledClassController.java
This is the class for the ScheduledClass controller.
16 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.curriculum.ScheduledClass;
import za.ac.cput.factory.curriculum.ScheduledClassFactory;
import za.ac.cput.service.curriculum.impl.ScheduledClassService;

import java.util.Set;

@RestController
@RequestMapping("/scheduledClass")
public class ScheduledClassController {
    @Autowired
    private ScheduledClassService scheduledClassService;

    @PostMapping("/create")
    public ScheduledClass create(@RequestBody ScheduledClass scheduledClass) {
        ScheduledClass newScheduledClass = ScheduledClassFactory.build(scheduledClass.getScheduledClassId(), scheduledClass.getSubjectCode(), scheduledClass.getRoomCode(), scheduledClass.getClassTime());
        return scheduledClassService.create(newScheduledClass);
    }

    @GetMapping("/read/{id}")
    public ScheduledClass read(@PathVariable String id) {
        return scheduledClassService.read(id);
    }

    @PostMapping("/update")
    public ScheduledClass update(@RequestBody ScheduledClass scheduledClass) {
        return scheduledClassService.update(scheduledClass);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return scheduledClassService.delete(id);
    }


    @GetMapping("/getAll")
    public Set<ScheduledClass> getAll() {
        return scheduledClassService.getAll();
    }
}
