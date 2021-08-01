package za.ac.cput.service.tertiaryInstitution.impl;
/**
 *
 * EnrollService.java
 * Implementation of Enroll Service
 * @author Tisetso Kotoana
 * 30 July 2021
 *
 */
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.repository.tertiaryInstitution.IEnrollRepository;
import za.ac.cput.repository.tertiaryInstitution.impl.EnrollRepository;
import za.ac.cput.service.tertiaryInstitution.IEnrollService;

import java.util.Set;

public class EnrollService implements IEnrollService {

    private static IEnrollService service = null;
    private IEnrollRepository repository;

    private EnrollService() {
        this.repository = EnrollRepository.getRepository();
    }

    public static IEnrollService getService(){
        if ( service == null) {
            service = new EnrollService();
        }
        return service;
    }

    @Override
    public Enroll create(Enroll enroll) {
        return this.repository.create(enroll);
    }

    @Override
    public Enroll read(String xy) {
        return this.repository.read(xy);
    }

    @Override
    public Enroll update(Enroll enroll) {
        return this.repository.update(enroll);
    }

    @Override
    public boolean delete(String studentID) {
        return this.repository.delete(studentID);
    }

    @Override
    public Set<Enroll> getAll() {
        return this.repository.getAll();
    }
}
