package DO_AN_FIX;

import java.util.Date;
import java.text.DecimalFormat;

public class Staff {
        private int staffID;
        private String firstName;
        private String midName;
        private String lastName;
        private double salary;
        private Date hireDate;


        public Staff(){}

        public Staff(int staffID, String firstName, String midName, String lastName, double salary, Date hireDate) {
            this.staffID = staffID;
            this.firstName = firstName;
            this.midName = midName;
            this.lastName = lastName;
            this.salary = salary;
            this.hireDate = hireDate;
        }

        public int getStaffID() {
            return staffID;
        }

        public void setStaffID(int staffID) {
            this.staffID = staffID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Date getHireDate() {
            return hireDate;
        }

        public void setHireDate(Date hireDate) {
            this.hireDate = hireDate;
        }

        public double calculateSalary(int daysWorked) {
            return (salary / 30) * daysWorked;
        }

        public String getFullname(){
            return firstName + " " + (midName.isEmpty() ? "" : midName + " ") + lastName;
        }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return "Staff{" +
                "staffID=" + staffID +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + df.format(salary) +
                ", hireDate=" + hireDate +
                '}';
    }


}

