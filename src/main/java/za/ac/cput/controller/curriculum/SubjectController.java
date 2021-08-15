package za.ac.cput.controller.curriculum;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.curriculum.Subject;

import za.ac.cput.factory.curriculum.SubjectFactory;

import za.ac.cput.service.curriculum.impl.SubjectService;


import java.util.Set;
/**
 *
 * Created SubjectController class.
 * Author: Shane Knoll (218279124)
 * Date:13 August 2021
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    private SubjectService subjectService;

    @PostMapping("/createsub")
    public Subject  create(@RequestBody Subject s){
     Subject  su = SubjectFactory.build(s.getSubjectCode(),s.getLecturerID(),s.getCourseCode(),s.getSemesterID());
        return  subjectService.create(su);
    }
    @GetMapping("/readsub")
    public Subject read(@PathVariable String id) {
        return subjectService.read(id);
    }

    @PostMapping("/updatesub")
    public Subject update(@RequestBody Subject subject) {
        return subjectService.update(subject);
    }

    @PostMapping("/deletesub")
    public boolean delete(@PathVariable String id) {
        return subjectService.delete(id);
    }


    @GetMapping("/getallsub")
    public Set<Subject> getAll() {
        return subjectService.getAll();
    }


}
