import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Staff {
        private int staffID;
        private String firstName;
        private String midName;
        private String lastName;
        private double salary;
        private String sex;
        private Date birthDate;
        private Date startDate;

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public Staff(){}

    public Staff(int staffID, String firstName, String midName, String lastName, double salary, String sex, Date birthDate, Date startDate) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.salary = salary;
        setSex(sex);  // Sử dụng phương thức setSex để đảm bảo giới tính hợp lệ
        this.birthDate = birthDate;
        this.startDate = startDate;
    }

    public void setSex(String sex) {
        if (sex.equalsIgnoreCase("Nam") || sex.equalsIgnoreCase("Nữ") || sex.equalsIgnoreCase("Khác")) {
                    this.sex = sex;
        } else {
                    throw new IllegalArgumentException("Giới tính phải là 'Nam', 'Nữ' hoặc 'Khác'.");
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
                ", birthDate=" + dateFormat.format(birthDate) +
                ", startDate=" + dateFormat.format(startDate) +
                '}';
    }
}

