package za.ac.cput.service.person.impl;

import za.ac.cput.entity.person.Lecturer;
import za.ac.cput.repository.person.impl.LecturerRepository;

import za.ac.cput.service.person.ILecturerService;

import java.util.Set;
/**
 *
 * Created LecturerService
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */
public class LecturerService implements ILecturerService {

    private static LecturerService Lecturerservice= null;
    private LecturerRepository repository;

    public LecturerService(){
        this.repository=LecturerRepository.getRepository();


    }

    public static LecturerService getService(){
        if(Lecturerservice==null){
            Lecturerservice= new LecturerService();

        }
        return Lecturerservice;

    }


    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }


    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }
}
