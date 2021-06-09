package za.ac.cput.Factory;

import za.ac.cput.Entity.Student;

import java.util.UUID;

public class StudentFactory {

    public static Student build(String firstName, String lastName, String emailAddress, String contactNo, int age){

        if(firstName.isEmpty() || lastName.isEmpty() || age <= 0) {
            return null;
        }

        String id = UUID.randomUUID().toString();

        return new Student.StudentBuilder()
                .setStudentId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .setContactNo(contactNo)
                .setAge(age)
                .build();
    }
}
