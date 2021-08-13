package za.ac.cput.service.person;

import za.ac.cput.entity.person.Lecturer;


import za.ac.cput.service.IService;

import java.util.Set;
/**
 *
 * Created ILecturerService
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */

public interface ILecturerService extends IService<Lecturer, String> {
    Set<Lecturer> getAll();
}
