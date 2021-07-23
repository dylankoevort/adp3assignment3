package za.ac.cput.repository.tertiaryInstitution.impl;

import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.repository.IRepository;
import za.ac.cput.repository.tertiaryInstitution.ISemesterRepository;

import java.util.HashSet;
import java.util.Set;
/**
 * SemesterRepository.java
 * DDD for Semester Repository
 * Author: Tisetso Kotoana
 * Date: 23 July 2021
 */

public class SemesterRepository implements ISemesterRepository {
    private static SemesterRepository repository = null;
    private Set<Semester> semesterDB;

    private SemesterRepository(){
        semesterDB= new HashSet<>();
    }

    public static SemesterRepository getRepository(){
        if(repository==null){
            repository = new SemesterRepository();

        }
        return repository;
    }

    @Override
    public Semester create(Semester enroll) {
        boolean qualify = this.semesterDB.add(enroll);
        if (!qualify){
            return null;
        }
        return enroll;
    }

    @Override
    public Semester read(String studentID) {
        for(Semester semester : semesterDB){
            if(semester.getSemesterID().equalsIgnoreCase(studentID)){
                return semester;
            }
        }
        return null;
    }

    @Override
    public Semester update(Semester semester) {
        Semester firstSemester = read(semester.getSemesterID());
        if(firstSemester != null){
            semesterDB.remove(firstSemester);
            semesterDB.add(semester);
            return semester;
        }
        return null;
    }

    @Override
    public boolean delete(String semesterID) {
        Semester semester = read(semesterID);
        if(semester != null){
            this.semesterDB.remove(semester);
            return true;
        }
        return false;
    }

    @Override
    public Set<Semester> getAll() {

        return semesterDB;
    }
}
