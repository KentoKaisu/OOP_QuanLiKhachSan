import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User {
    private Staff[] staffList = new Staff[0];
    private int staffCount = 0;

    public Admin() {
        super("admin", "12345", "ADMIN");
    }

    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }

    // Menu quản lý nhân viên
    public void manageStaff() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý nhân viên:");
            System.out.println("1. Thêm nhân viên.");
            System.out.println("2. Xóa nhân viên.");
            System.out.println("3. Hiển thị danh sách nhân viên.");
            System.out.println("4. Tính lương cho nhân viên.");
            System.out.println("5. Tìm kiếm nhân viên theo thuộc tính.");
            System.out.println("6. Thống kê nhân viên.");
            System.out.println("0. Quay lại menu chính.");
            System.out.print("Chọn chức năng: ");

            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStaff(sc);
                case 2 -> deleteStaff(sc);
                case 3 -> displayStaffList();
                case 4 -> calculateSalary(sc);
                case 5 -> searchStaff(sc);
                case 6 -> statistics();
                case 0 -> System.out.println("Quay lại menu chính...");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    // Thêm nhân viên mới
    private void addStaff(Scanner sc){
        System.out.print("Nhập ID nhân viên: ");
        int id;
        while (true){
            while(!sc.hasNextInt()){
                System.out.println("Vui lòng nhập số!");
                sc.next();
            }
            id = sc.nextInt();
            sc.nextLine();

            if(id > 0 && isUniqueID(id)){
                break;
            }else {
                System.out.println("ID không hợp lệ hoặc đã tồn tại, hãy nhập ID khác.");
            }
        }

        System.out.print("Nhập họ nhân viên: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Nhập tên lót nhân viên(nếu có): ");
        String middleName = sc.nextLine().trim();

        System.out.print("Nhập tên nhân viên(nếu có): ");
        String lastName = sc.nextLine().trim();

        System.out.println("Nhập lương cơ bản: ");
        double salary;
        while (!sc.hasNextDouble()) {
            System.out.println("Vui lòng nhập đúng định dạng.");
            sc.next();
        }
        salary = sc.nextDouble();
        sc.nextLine();

        String sex;
        while (true){
            System.out.print("Nhập giới tính (nam / nữ / khác): ");
            sex = sc.nextLine().trim();
            if(sex.equalsIgnoreCase("nam") || sex.equalsIgnoreCase("nữ") || sex.equalsIgnoreCase("khác")){
                break;
            }else {
                System.out.println("Giới tính không hợp lệ vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthDateStr = sc.nextLine();
        System.out.println("Nhập ngày bắt đầu làm việc (dd/MM/yyyy): ");
        String startDateStr = sc.nextLine();

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = dateFormat.parse(birthDateStr);
            Date startDate = dateFormat.parse(startDateStr);

            Staff newStaff = new Staff(id, firstName, middleName, lastName, salary, sex, birthDate, startDate);
            addToStaffList(newStaff);
            System.out.println("Đã thêm nhân viên mới thành công.");
        }catch (ParseException e){
            System.out.println("Nhập lại ngày theo đúng định dạng.");
        }
    }

    
    // Thêm nhân viên vào danh sách
    private void addToStaffList(Staff staff) {
        Staff[] newStaffList = new Staff[staffCount + 1];
        System.arraycopy(staffList, 0, newStaffList, 0, staffCount); // mảng bắt đầu, vtbđ, mảng đích, vị trí vào mảng đích, số lượng đầu vào
        newStaffList[staffCount] = staff;
        staffList = newStaffList;
        staffCount++;
    }

    // kiểm tra ID nhân viên có duy nhất không
    private boolean isUniqueID(int id) {
        for (Staff staff : staffList) {
            if (staff != null && staff.getStaffID() == id) {
                return false;
            }
        }
        return true;
    }

    // Xóa nhân viên theo ID
    private void deleteStaff(Scanner sc) {
        if (staffCount == 0) {
            System.out.println("Danh sách nhân viên trống. Không thể xóa.");
            return;
        }

        System.out.print("Nhập ID nhân viên cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        Staff[] newStaffList = new Staff[staffCount - 1];
        int index = 0;

        for (Staff staff : staffList) {
            if (staff != null && staff.getStaffID() != id) {
                newStaffList[index++] = staff;
            } else if (staff != null) {
                found = true;
            }
        } // for each để duyệt hết mảng

        if (found) {
            staffList = newStaffList;
            staffCount--;
            System.out.println("Đã xóa nhân viên thành công.");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID này.");
        }
    }

    // Hiển thị danh sách nhân viên
    private void displayStaffList() {
        System.out.println("\nDanh sách nhân viên:");
        if (staffCount == 0) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            for (Staff staff : staffList) {
                if (staff != null) {
                    System.out.println(staff);
                }
            }
        }
    }

    // Tính lương cho nhân viên
    public void calculateSalary(Scanner sc) {
        System.out.print("Nhập ID của nhân viên: ");
        int id = sc.nextInt();
        System.out.print("Nhập số ngày làm việc: ");
        int daysWorked = sc.nextInt();
        sc.nextLine();

        for (Staff staff : staffList) {
            if (staff != null && staff.getStaffID() == id) {
                double dailySalary = staff.getSalary() / 30;
                double totalSalary = dailySalary * daysWorked;
                System.out.printf("Lương của nhân viên %s (%d) là: %.2f", staff.getFullname(), id, totalSalary);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có ID này");
    }

    // tìm theo khoảng lương
    private boolean isSalaryInRange(double salary, String salaryRange){
        String[] range = salaryRange.split("-");
        double min = Double.parseDouble(range[0]);
        double max = Double.parseDouble(range[1]);
        return salary >= min && salary <= max;
    }

    // Tìm kiếm nhân viên theo thuộc tính
    private void searchStaff(Scanner sc){
        boolean[] confirmAttributes = new boolean[6];
        String[] attibutes = new String[6];
        int option;

        do{
            System.out.println("\nHãy nhập thuộc tính bạn muốn chọn:");
            System.out.println("1. ID nhân viên");
            System.out.println("2. Họ nhân viên");
            System.out.println("3. Tên đệm nhân viên");
            System.out.println("4. Tên nhân viên");
            System.out.println("5. Giới tính");
            System.out.println("6. Khoảng lương");
            System.out.println("0. Bắt đầu tìm kiếm");

            System.out.println("Nhập số tương ứng để chọn thuộc tính");
            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập đúng số tương ứng.");
                sc.next();
            }
            option = sc.nextInt();
            sc.nextLine();

            if(option >= 1 && option <= 6){
                confirmAttributes[option - 1] = true;
                System.out.println("Chọn thành công");
            }else if (option != 0){
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (option != 0);

        if(confirmAttributes[0]){
            do{
                System.out.println("nhập ID nhân viên: ");
                attibutes[0] = sc.nextLine().trim();
                if(attibutes[0].isEmpty() || !attibutes[0].matches("\\d+")){
                    System.out.println("ID phải là một số hợp lệ. Vui lòng nhập lại.");
                    attibutes[0] = null;
                }
            }while (attibutes[0] == null);
        }
        if (confirmAttributes[1]) { // Họ nhân viên
            System.out.print("Nhập họ nhân viên: ");
            attibutes[1] = sc.nextLine().trim();
        }
        if (confirmAttributes[2]) { // Tên đệm nhân viên
            System.out.print("Nhập tên đệm nhân viên: ");
            attibutes[2] = sc.nextLine().trim();
        }
        if (confirmAttributes[3]) { // Tên nhân viên
            System.out.print("Nhập tên nhân viên: ");
            attibutes[3] = sc.nextLine().trim();
        }
        if(confirmAttributes[4]){
            do{
                System.out.println("Nhập giới tính cho nhân viên: ");
                attibutes[4] = sc.nextLine().trim();
                if(!attibutes[4].equalsIgnoreCase("Nam") &&
                        !attibutes[4].equalsIgnoreCase("Nữ") &&
                        !attibutes[4].equalsIgnoreCase("Khác")){
                    System.out.println("Giới tính không hợp lệ, hãy nhập lại");
                    attibutes[4] = null;
                }
            }while (attibutes[4] == null);
        }
        if(confirmAttributes[5]){
            double minSalary = Double.MIN_VALUE, maxSalary = Double.MAX_VALUE;
            do{
                System.out.println("nhập lương tối thiểu");
                while(!sc.hasNextDouble()){
                    System.out.println("Vui lòng nhập số hợp lệ");
                    sc.next();
                }
                minSalary = sc.nextDouble();
                System.out.print("Nhập lương tối đa: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Vui lòng nhập số hợp lệ.");
                    sc.next();
                }
                maxSalary = sc.nextDouble();
                sc.nextLine();

                if (minSalary > maxSalary) {
                    System.out.println("Lương tối thiểu không được lớn hơn lương tối đa. Vui lòng nhập lại.");
                }
            }while (minSalary > maxSalary);
            attibutes[5] = minSalary + "-" + maxSalary;
        }
        System.out.println("Kết quả tìm kiếm: ");
        boolean found = false;
        for(Staff staff: staffList){
            if(staff != null &&
                    (attibutes[0] == null || String.valueOf(staff.getStaffID()).equals(attibutes[0])) &&
                    (attibutes[1] == null || staff.getFirstName().equalsIgnoreCase(attibutes[1])) &&
                    (attibutes[2] == null || staff.getMidName().equalsIgnoreCase(attibutes[2])) &&
                    (attibutes[3] == null || staff.getLastName().equalsIgnoreCase(attibutes[3])) &&
                    (attibutes[4] == null || staff.getSex().equalsIgnoreCase(attibutes[4])) &&
                    (attibutes[5] == null || isSalaryInRange(staff.getSalary(), attibutes[5]))) {
                System.out.println(staff);
                found = true;
            }
        }
        if(!found){
            System.out.println("không tìm thấy nhân viên nào thỏa điều kiện trên!");
        }
    }

    // Thống kê nhân viên
    /*private void statistics(Scanner sc) {
        int choice;

        do {
            System.out.println("\nThống kê nhân viên:");
            System.out.println("1. Thống kê độ tuổi.");
            System.out.println("2. Thống kê giới tính.");
            System.out.println("3. Thống kê nhân viên theo khoảng lương.");
            System.out.println("4. Thống kê thời gian làm việc.");
            System.out.println("0. Thoát.");
            System.out.print("Chọn chức năng: ");

            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> ageStatistics();
                case 2 -> genderStatistics();
                case 3 -> salaryRangeStatistics(sc);
                case 4 -> workingTimeStatistics();
                case 0 -> System.out.println("Thoát thống kê...");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }*/

    private void statistics(){
        System.out.println("THỐNG KÊ NHÂN VIÊN");
        System.out.println("========================================================================================");
        System.out.printf("%-30s", "Độ tuổi");
        String ageStatic = ageStatistics();
        System.out.printf("%-30s", ageStatic);

        System.out.printf("%-30s", "Giới tính");
        String genderStats = genderStatistics();
        System.out.printf("%-30s", genderStats);

        System.out.printf("%-30sn", "Khoảng Lương");
        String salaryStats = salaryRangeStatistics();
        System.out.printf("%-30sn", salaryStats);

        System.out.printf("%-30sn", "Thời Gian Làm Việc");
        String workingTimeStats = workingTimeStatistics();
        System.out.printf("%-30sn", workingTimeStats);
        System.out.println("========================================================================================");
    }

    private int calculateAge(Date birthDate) {
        if (birthDate == null) return -1;
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    private String ageStatistics() {
        int under30 = 0, between30And50 = 0, over50 = 0;

        for (Staff staff : staffList) {
            if (staff != null) {
                int age = calculateAge(staff.getBirthDate());
                if (age < 30) {
                    under30++;
                } else if (age >= 30 && age <= 50) {
                    between30And50++;
                } else if (age > 50) {
                    over50++;
                }
            }
        }

        // Trả về chuỗi kết quả
        return "Dưới 30: " + under30 + ", 30-50: " + between30And50 + ", Trên 50: " + over50;
    }


    private String genderStatistics() {
        int male = 0, female = 0, other = 0;

        for (Staff staff : staffList) {
            if (staff != null) {
                String gender = staff.getSex();
                if (gender.equalsIgnoreCase("Nam")) {
                    male++;
                } else if (gender.equalsIgnoreCase("Nữ")) {
                    female++;
                } else {
                    other++;
                }
            }
        }

        // Trả về chuỗi kết quả
        return "Nam: " + male + ", Nữ: " + female + ", Khác: " + other;
    }

    private String salaryRangeStatistics() {
        double minSalary = 500000; // Khoảng lương thấp nhất
        double maxSalary = 100000000; // Khoảng lương cao nhất
        int count = 0;

        for (Staff staff : staffList) {
            if (staff != null && staff.getSalary() >= minSalary && staff.getSalary() <= maxSalary) {
                count++;
            }
        }
        return "Từ " + minSalary + " đến " + maxSalary + ": " + count + " nhân viên";
    }


    private String workingTimeStatistics() {
        int lessThan5Years = 0, between5And10Years = 0, moreThan10Years = 0;

        for (Staff staff : staffList) {
            if (staff != null) {
                int workingYears = calculateWorkingYears(staff.getStartDate());
                if (workingYears < 5) {
                    lessThan5Years++;
                } else if (workingYears >= 5 && workingYears <= 10) {
                    between5And10Years++;
                } else if (workingYears > 10) {
                    moreThan10Years++;
                }
            }
        }

        // Trả về chuỗi kết quả
        return "Dưới 5 năm: " + lessThan5Years + ", 5-10 năm: " + between5And10Years + ", Trên 10 năm: " + moreThan10Years;
    }

    private int calculateWorkingYears(Date startDate) {
        if(startDate == null) return -1;
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar today = Calendar.getInstance();

        int yearsWorked = today.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        if(today.get(Calendar.MONTH) < start.get(Calendar.MONTH) || (today.get(Calendar.MONTH) == start.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < start.get(Calendar.DAY_OF_MONTH))){
            yearsWorked--;
        }
        return  yearsWorked;
    }
}
