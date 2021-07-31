package za.ac.cput.service.tertiaryInstitution.impl;

/**
 *
 * SemesterService.java
 * Implementation of Semester Service
 * @author Tisetso Kotoana
 * 30 July 2021
 *
 */
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.repository.tertiaryInstitution.ISemesterRepository;
import za.ac.cput.repository.tertiaryInstitution.impl.SemesterRepository;
import za.ac.cput.service.tertiaryInstitution.ISemesterService;
import java.util.Set;

public class SemesterService implements ISemesterService {
    private static ISemesterService service = null;
    private ISemesterRepository repository;

    private SemesterService() {
        this.repository = SemesterRepository.getRepository();
    }

    public static ISemesterService getService(){
        if ( service == null) {
            service = new SemesterService();
        }
        return service;
    }

    @Override
    public Semester create(Semester semester) {
        return this.repository.create(semester);
    }

    @Override
    public Semester read(String xy) {
        return this.repository.read(xy);
    }

    @Override
    public Semester update(Semester semester) {
        return this.repository.update(semester);
    }

    @Override
    public boolean delete(String studentID) {
        return this.repository.delete(studentID);
    }

    @Override
    public Set<Semester> getAll() {
        return this.repository.getAll();
    }
}
