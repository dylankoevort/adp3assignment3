package za.ac.cput.repository.curriculum.impl;

/**
 *
 * ExaminationRepository.java
 * Implementation of IExaminationRepository by ExaminationRepository
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 */

import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.repository.curriculum.IExaminationRepository;

import java.util.HashSet;
import java.util.Set;

public class ExaminationRepository implements IExaminationRepository {
    private static ExaminationRepository repository = null;
    private Set<Examination> examinationDb;

    private ExaminationRepository() {
        this.examinationDb = new HashSet<Examination>();
    }

    public static ExaminationRepository getRepository() {
        if (repository == null) {
            repository = new ExaminationRepository();
        }
        return repository;
    }

    @Override
    public Examination create(Examination examination) {
        boolean ok = this.examinationDb.add(examination);
        if(!ok) {
            return null;
        }
        return examination;
    }

    public Examination read(String examinationId) {
        for( Examination examination : examinationDb) {
            if(examination.getExamId().equalsIgnoreCase(examinationId)) {
                return examination;
            }
        }
        return null;
    }

    @Override
    public Examination update(Examination examination) {
        Examination oldExamination = read(examination.getExamId());
        if(oldExamination != null) {
            examinationDb.remove(oldExamination);
            examinationDb.add(examination);
            return examination;
        }
        return null;
    }

    @Override
    public boolean delete(String examinationId) {
        Examination examination = read(examinationId);
        if(examination != null) {
            this.examinationDb.remove(examination);
            return true;
        }
        return false;
    }

    @Override
    public Set<Examination> getAll() {
        return examinationDb;
    }
}
