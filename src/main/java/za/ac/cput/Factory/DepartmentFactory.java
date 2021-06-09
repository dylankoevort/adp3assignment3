package za.ac.cput.Factory;
import java.util.UUID;
import za.ac.cput.Entity.Course;
import za.ac.cput.Entity.Department;

/**
 * DepartmentFactory.java
 * Factory class for Department.java
 * @author Jonathan Kleynhans 217268153
 * 09 June 2021
 */

public class DepartmentFactory {

        public static Department build (int departmentID, String departmentName, String departmentDesc){

            if( departmentID <= 0 || departmentName.isEmpty() || departmentDesc.isEmpty() ){
                return null;
            }

            return new Department.DepartmentBuilder()
                    .setDepartmentID(departmentID)
                    .setDepartmentName(departmentName)
                    .setDepartmentDesc(departmentDesc)
                    .build();
        }
    }
