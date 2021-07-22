package za.ac.cput.repository.curriculum.impl;

import za.ac.cput.entity.curriculum.Subject;
import za.ac.cput.repository.curriculum.ISubjectRepository;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * Created SubjectRepository
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
public class SubjectRepository implements ISubjectRepository {
    private static SubjectRepository Subjectrepository= null;
    private Set<Subject> SubjectDB = null;

    private SubjectRepository(){

        SubjectDB = new HashSet<>();
    }

    public  static  SubjectRepository getRepository(){

        if(Subjectrepository==null){
            Subjectrepository= new SubjectRepository();
        }
        return Subjectrepository;
    }

    @Override
    public Subject create(Subject subject){
        boolean success = SubjectDB.add(subject);
        if(!success)
            return null;
        return subject;
    }

    @Override
    public Subject read(String SubjectID){

        for(Subject s: SubjectDB) {
            if(s.getSubjectCode().equals(SubjectID)){
                return s;
            }
        }
        return null;
    }

    @Override
    public Subject update(Subject s){

        Subject lect = read(s.getSubjectCode());
        if(lect!=null){
            SubjectDB.remove(lect);
            SubjectDB.add(s);
            return s;

        }
        return null;
    }


    @Override
    public boolean delete(String SubjectID){
        Subject delete = read(SubjectID);
        if(delete==null)
            return false;
        SubjectDB.remove(delete);
        return true;

    }



    @Override
    public Set<Subject> getAll() {
        return SubjectDB;
    }
}





