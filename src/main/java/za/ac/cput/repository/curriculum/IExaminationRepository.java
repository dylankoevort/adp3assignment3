package za.ac.cput.repository.curriculum;

/**
 *
 * IExaminationRepository.java
 * ExaminationRepository interface
 * @author Dylan Koevort 218088159
 * 19 July 2021
 *
 */

import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Deprecated
public interface IExaminationRepository extends IRepository<Examination, String> {
    public Set<Examination> getAll();
}
