package za.ac.cput.repository.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/**
 * IEnrollRepository.java
 * DDD for Enroll Repository
 * Author: Tisetso Kotoana
 * Date: 23 July 2021
 */
public interface IEnrollRepository extends IRepository<Enroll, String> {
    public Set<Enroll> getAll();
}
