package za.ac.cput.Entity;

/**
 * Course.java
 * Course entity created using builder pattern.
 * @author Jonathan Kleynhans 217268153
 * 01 June 2021
 */

public class Department {

    private int departmentID;
    private String departmentName, departmentDesc;

    public Department(DepartmentBuilder department){
        this.departmentID = department.departmentID;
        this.departmentName = department.departmentName;
        this.departmentDesc = department.departmentDesc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDesc='" + departmentDesc + '\'' +
                '}';
    }

    public static class DepartmentBuilder {

        private int departmentID;
        private String departmentName, departmentDesc;

        public DepartmentBuilder setDepartmentID(int departmentID) {
            this.departmentID = departmentID;
            return this;
        }

        public DepartmentBuilder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public DepartmentBuilder setDepartmentDesc(String departmentDesc) {
            this.departmentDesc = departmentDesc;
            return this;
        }

        public Department build(){
            return new Department(this);
        }

        public DepartmentBuilder copy(Department department){
            this.departmentID = department.departmentID;
            this.departmentName = department.departmentName;
            this.departmentDesc = department.departmentDesc;

            return this;
        }

    }
}
