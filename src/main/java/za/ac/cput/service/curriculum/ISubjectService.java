package za.ac.cput.service.curriculum;

import za.ac.cput.entity.curriculum.Subject;

import za.ac.cput.service.IService;

import java.util.Set;
/**
 *
 * Created ISubjectService
 * Author: Shane Knoll (218279124)
 * 29 July2021
 */
public interface ISubjectService extends IService<Subject, String> {
    Set<Subject> getAll();
}
