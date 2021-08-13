package za.ac.cput.controller.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.factory.curriculum.ExaminationFactory;
import za.ac.cput.service.curriculum.impl.ExaminationService;

import java.util.Set;

@RestController
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;

    @PostMapping("/create")
    public Examination create(@RequestBody Examination examination) {
        Examination newExamination = ExaminationFactory.build(examination.getSubjectCode(), examination.getExamDesc(), examination.getExamDate());
        return examinationService.create(newExamination);
    }

    @GetMapping("/read/{id}")
    public Examination read(@PathVariable String id) {
        return examinationService.read(id);
    }

    @PostMapping("/update")
    public Examination update(@RequestBody Examination examination) {
        return examinationService.update(examination);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return examinationService.delete(id);
    }


    @GetMapping("/getall")
    public Set<Examination> getAll() {
        return examinationService.getAll();
    }
}
