import java.text.DecimalFormat;

public class Staff {
        private int staffID;
        private String firstName;
        private String midName;
        private String lastName;
        private double salary;
        private String sex;

        public Staff(){}
        public Staff(int staffID, String firstName, String midName, String lastName, double salary, String sex) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.salary = salary;
        setSex(sex);  // Sử dụng phương thức setSex để đảm bảo giới tính hợp lệ
    }

        public void setSex(String sex) {
            if (sex.equalsIgnoreCase("Nam") || sex.equalsIgnoreCase("Nữ") || sex.equalsIgnoreCase("Khác")) {
                this.sex = sex;
            } else {
                throw new IllegalArgumentException("Giới tính phải là 'Nam', 'Nữ' hoặc 'Khác'.");
            }
        }

    public String getSex() {
        return sex;
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
                ", sex='" + sex + '\'' +
                '}';
    }


}
