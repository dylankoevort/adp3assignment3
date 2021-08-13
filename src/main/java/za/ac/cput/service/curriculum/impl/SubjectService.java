package za.ac.cput.service.curriculum.impl;

import za.ac.cput.entity.curriculum.Subject;

import za.ac.cput.repository.curriculum.impl.SubjectRepository;
import za.ac.cput.service.curriculum.ISubjectService;

import java.util.Set;
/**
 *
 * Created SubjectService
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */
public class SubjectService implements ISubjectService {
    private static SubjectService Subjectservice= null;
    private SubjectRepository repository;

    public SubjectService(){
        this.repository=SubjectRepository.getRepository();


    }

    public static SubjectService getService(){
        if(Subjectservice==null){
            Subjectservice= new SubjectService();

        }
        return Subjectservice;

    }


    @Override
    public Subject create(Subject subject) {
        return this.repository.create(subject);
    }

    @Override
    public Subject read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.update(subject);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }


    @Override
    public Set<Subject> getAll() {
        return this.repository.getAll();
    }

}


