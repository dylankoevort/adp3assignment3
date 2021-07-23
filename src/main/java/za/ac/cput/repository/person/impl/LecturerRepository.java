package za.ac.cput.repository.person.impl;

import za.ac.cput.entity.person.Lecturer;
import za.ac.cput.repository.person.ILecturerRepository;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * Created LecturerRepository
 * Author: Shane Knoll (218279124)
 * 22 July2021
 */
public class LecturerRepository implements ILecturerRepository{
    private static LecturerRepository repository= null;
    private Set<Lecturer> lecturerDB = null;

    private LecturerRepository(){

        lecturerDB = new HashSet<>();
    }

    public  static  LecturerRepository getRepository(){

        if(repository==null){
            repository= new LecturerRepository();
        }
        return repository;
    }

    @Override
    public Lecturer create(Lecturer lecturer){
        boolean success = lecturerDB.add(lecturer);
        if(!success)
            return null;
        return lecturer;
    }


    @Override
    public Lecturer read(String LectuerID){

        for(Lecturer l: lecturerDB) {
            if(l.getLecturerID().equals(LectuerID)){
                return l;
            }
        }
        return null;
    }

    @Override
    public Lecturer update(Lecturer le){

        Lecturer lect = read(le.getLecturerID());
        if(lect!=null){
            lecturerDB.remove(lect);
            lecturerDB.add(le);
            return le;

        }
        return null;
    }


    @Override
    public boolean delete(String lecturerID){
        Lecturer delete = read(lecturerID);
        if(delete==null)
            return false;
        lecturerDB.remove(delete);
        return true;

    }



    @Override
    public Set<Lecturer> getAll() {
        return lecturerDB;
    }
}

