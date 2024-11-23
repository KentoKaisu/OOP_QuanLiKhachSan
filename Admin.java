import java.util.Scanner;

public class Admin extends User{
    private Staff[] staffList = new Staff[0];
    private int staffCount = 0;

    public Admin() {
        super("admin", "12345", "ADMIN");
    }

    @Override
    public boolean login(String username, String password){
        return getUsername().equals(username) && getPassword().equals(password);
    }

    // Quản lí nhân viên
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
            System.out.println("0. Quay lại menu chính.");
            System.out.print("Chọn chức năng: ");

            while (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStaff(sc);
                    break;

                case 2:
                    deleteStaff(sc);
                    break;

                case 3:
                    displayStaffList();
                    break;

                case 4:
                    calculateSalary(sc);
                    break;

                case 5:
                    searchStaff(sc);
                    break;

                case 0:
                    System.out.println("Quay lại menu chính...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    // thêm 1 nhân viên vào mảng
    private void addStaff(Scanner sc) {
        int id = 0;
        boolean existed;
        do {
            System.out.print("Nhập ID nhân viên: ");
            existed = false;
            try {
                id = sc.nextInt();
                sc.nextLine();
                for (Staff staff : staffList) {
                    if (staff != null && staff.getStaffID() == id) {
                        existed = true;
                        System.out.println("ID đã tồn tại, vui lòng nhập ID khác");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("ID phải là một số hợp lệ. Vui lòng nhập lại.");
                sc.nextLine();
            }
        } while (id <= 0 || existed);


        System.out.print("Nhập họ nhân viên: ");
        String firstName = sc.nextLine();
        System.out.print("Nhập tên đệm nhân viên (nếu có): ");
        String midName = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String lastName = sc.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        //Nhập giới tính cho nhân viên
        String sex = "";
        while(true){
            System.out.print("Nhập giới tính: ");
            sex = sc.nextLine();
            if(sex.equalsIgnoreCase("Nam") || sex.equalsIgnoreCase("Nữ") || sex.equalsIgnoreCase("Khác")){
                break;
            }else{
                System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // tăng kích thước mảng thêm 1
        Staff[] newStaffList = new Staff[staffCount+1];
        for(int i = 0; i < staffCount; i++){
            newStaffList[i] = staffList[i];
        }

        // thêm nhân viên mới vào cuối mảng mới
        newStaffList[staffCount] = new Staff(id, firstName, midName, lastName, salary, sex);
        staffList = newStaffList;
        staffCount++;
        System.out.println("đã thêm nhân viên mới thành công");
    }

    // xóa nhân viên theo ID
    private void deleteStaff(Scanner sc) {
        if (staffCount <= 0) {
            System.out.println("Danh sách nhân viên trống. Không thể xóa.");
            return;
        }
        System.out.print("Nhập ID nhân viên cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        Staff[] newStaffList = new Staff[staffCount - 1];
        int index = 0;
        for(int i = 0; i < staffCount ; i++){
            if(staffList[i].getStaffID() == id){
                found = true;
            }
            else {
                if(index < newStaffList.length){
                    newStaffList[index] = staffList[i];
                    index++;
                }
            }
        }
        if(found){
            staffList = newStaffList;
            staffCount--;
            System.out.println("Đã xóa thành công 1 nhân viên!");
        }
        else {
            System.out.println("Không tìm thấy nhân viên có ID này!");
        }
    }

    // in danh sách nhân viên
    private void displayStaffList() {
        System.out.println("\nDanh sách nhân viên:");
        boolean hasStaff = false;
        for (Staff staff : staffList) {
            if (staff != null) {
                System.out.println(staff);
                hasStaff = true;
            }
        }
        if (!hasStaff) {
            System.out.println("Danh sách nhân viên trống.");
        }
    }

    // tính lương
    public void calculateSalary(Scanner sc) {
        System.out.print("Nhập IO của nhân viên: ");
        int id = sc.nextInt();
        System.out.print("Nhập số ngày làm việc: ");
        int daysWorked = sc.nextInt();
        sc.nextLine();

        for(Staff staff : staffList){
            if(staff != null && staff.getStaffID() == id){
                double dailySalary = staff.getSalary() / 30;
                double totalSalary = dailySalary * daysWorked;
                System.out.printf("Lương của nhân viên %s (%d) là: %.2f", staff.getFullname(), id, totalSalary);
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có ID này");
    }

    // tìm kiếm nâng cao
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
    // tìm theo khoảng lương
    private boolean isSalaryInRange(double salary, String salaryRange){
        String[] range = salaryRange.split("-");
        double min = Double.parseDouble(range[0]);
        double max = Double.parseDouble(range[1]);
        return salary >= min && salary <= max;
    }

}
