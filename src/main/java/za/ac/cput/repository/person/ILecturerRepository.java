package za.ac.cput.repository.person;

import za.ac.cput.entity.person.Lecturer;
import za.ac.cput.repository.IRepository;

import java.util.Set;
/**
 *
 * Created ILecturerRepository
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
public interface ILecturerRepository extends IRepository<Lecturer,String> {
    public Set<Lecturer> getAll();
}
