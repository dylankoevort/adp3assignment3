package za.ac.cput.service.curriculum.impl;

/*
Dinelle Kotze
219089302
ExaminationService.java
This is the service implementation for the Examination entity.
31 July 2021
 */

import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.repository.curriculum.IExaminationRepository;
import za.ac.cput.repository.curriculum.impl.ExaminationRepository;
import za.ac.cput.service.curriculum.IExaminationService;

import java.util.Set;

public class ExaminationService implements IExaminationService {
    private static IExaminationService service = null;
    private IExaminationRepository repository;

    private ExaminationService() {
        this.repository = ExaminationRepository.getRepository();
    }

    public static IExaminationService getService(){
        if ( service == null) {
            service = new ExaminationService();
        }
        return service;
    }

    @Override
    public Examination create(Examination examination) {
        return this.repository.create(examination);
    }

    @Override
    public Examination read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Examination update(Examination examination) {
        return this.repository.update(examination);
    }

    @Override
    public boolean delete(String examinationId) {
        return this.repository.delete(examinationId);
    }

    @Override
    public Set<Examination> getAll() {
        return this.repository.getAll();
    }
}
