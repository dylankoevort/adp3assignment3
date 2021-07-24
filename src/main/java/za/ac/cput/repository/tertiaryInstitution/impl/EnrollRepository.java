package za.ac.cput.repository.tertiaryInstitution.impl;

import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.repository.tertiaryInstitution.IEnrollRepository;

import java.util.HashSet;
import java.util.Set;
/**
 * EnrollRepository.java
 * DDD for Enroll Repository
 * Author: Tisetso Kotoana
 * Date: 23 July 2021
 */
public class EnrollRepository implements IEnrollRepository {
    private static EnrollRepository repository = null;
    private Set<Enroll> enrollDB;

    private EnrollRepository(){
        enrollDB= new HashSet<>();
    }

    public static EnrollRepository getRepository(){
        if(repository==null){
            repository = new EnrollRepository();

        }
        return repository;
    }

    @Override
    public Enroll create(Enroll enroll) {
        boolean qualify = this.enrollDB.add(enroll);
        if (!qualify){
            return null;
        }
        return enroll;
    }

    @Override
    public Enroll read(String studentID) {
        for(Enroll enroll : enrollDB){
            if(enroll.getStudentID().equalsIgnoreCase(studentID)){
                return enroll;
            }
        }
        return null;
    }

    @Override
    public Enroll update(Enroll enroll) {
        Enroll initialEnrollment = read(enroll.getStudentID());
        if(initialEnrollment != null){
            enrollDB.remove(initialEnrollment);
            enrollDB.add(enroll);
            return enroll;
        }
        return null;
    }

    @Override
    public boolean delete(String studentID) {
        Enroll enroll = read(studentID);
        if(enroll != null){
            this.enrollDB.remove(enroll);
            return true;
        }
        return false;
    }

    @Override
    public Set<Enroll> getAll() {

        return enrollDB;
    }
}
