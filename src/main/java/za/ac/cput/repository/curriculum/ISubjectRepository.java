package za.ac.cput.repository.curriculum;

import za.ac.cput.entity.curriculum.Subject;
import za.ac.cput.repository.IRepository;

import java.util.Set;
/**
 *
 * Created ISubjectRepository
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
public interface ISubjectRepository extends IRepository<Subject,String> {
    public Set<Subject> getAll();
}
