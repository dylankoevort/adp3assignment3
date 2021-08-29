package za.ac.cput.service.curriculum.impl;

/*
Dinelle Kotze
219089302
ExaminationService.java
This is the service implementation for the Examination entity.
31 July 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.repository.curriculum.impl.ExaminationRepository;
import za.ac.cput.service.curriculum.IExaminationService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExaminationService implements IExaminationService {
    private static IExaminationService service = null;

    @Autowired
    private ExaminationRepository repository;

    @Override
    public Examination create(Examination examination) { return this.repository.save(examination); }

    @Override
    public Examination read(String scheduledClassId) { return this.repository.findById(scheduledClassId).orElse(null); }

    @Override
    public Examination update(Examination examination) {
        if (this.repository.existsById(examination.getExamId()))
            return this.repository.save(examination);
        return null;
    }

    @Override
    public boolean delete(String examinationId) {
        this.repository.deleteById(examinationId);
        if (this.repository.existsById(examinationId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Examination> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Examination getExaminationGivenDescription(String examinationDescription){
        Examination e = null;
        Set<Examination> examinations = getAll();
        for (Examination examination : examinations) {
            if (examination.getExamDesc().equals(examinationDescription)) {
                e = examination;
                break;
            }
        }
        return e;
    }
}
