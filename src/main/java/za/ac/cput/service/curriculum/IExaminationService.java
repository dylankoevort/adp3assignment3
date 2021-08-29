package za.ac.cput.service.curriculum;

/*
Dinelle Kotze
219089302
IExaminationService.java
This is the service interface for the Examination entity.
31 July 2021
 */

import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IExaminationService extends IService <Examination, String> {
    Set<Examination> getAll();
    public Examination getExaminationGivenDescription(String examinationDescription);
}
