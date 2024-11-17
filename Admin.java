package DO_AN_FIX;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User{
    private static final int MAX_STAFF = 10;
    private Staff[] staffList = new Staff[MAX_STAFF];

    public Admin() {
        super("admin", "12345", "ADMIN");
    }

    @Override
    public boolean login(String username, String password){
        return getUsername().equals(username) && getPassword().equals(password);
    }

    public void manageStaff() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nQuản lý nhân viên:");
            System.out.println("1. Thêm nhân viên.");
            System.out.println("2. Xóa nhân viên.");
            System.out.println("3. Hiển thị danh sách nhân viên.");
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

                case 0:
                    System.out.println("Quay lại menu chính...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    private void addStaff(Scanner sc) {
        int emptyIndex = findEmptySlot();
        if (emptyIndex == -1) {
            System.out.println("Danh sách nhân viên đã đầy. Không thể thêm mới.");
            return;
        }

        System.out.print("Nhập ID nhân viên: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập họ nhân viên: ");
        String firstName = sc.nextLine();
        System.out.print("Nhập tên đệm nhân viên (nếu có): ");
        String midName = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String lastName = sc.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập ngày tuyển dụng (dd-MM-yyyy): ");
        String hireDateInput = sc.nextLine();
        Date hireDate;

        try {
            hireDate = new java.text.SimpleDateFormat("dd-MM-yyyy").parse(hireDateInput);
        } catch (Exception e) {
            System.out.println("Ngày tuyển dụng không hợp lệ. Sử dụng ngày hiện tại.");
            hireDate = new Date();
        }

        staffList[emptyIndex] = new Staff(id, firstName, midName, lastName, salary, hireDate);
        System.out.println("Thêm nhân viên thành công!");
    }


    private void deleteStaff(Scanner sc) {
        System.out.print("Nhập ID nhân viên cần xóa: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < staffList.length; i++) {
            if (staffList[i] != null && staffList[i].getStaffID() == id) {
                staffList[i] = null;
                System.out.println("Xóa nhân viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với ID này.");
    }

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

    private int findEmptySlot() {
        for (int i = 0; i < staffList.length; i++) {
            if (staffList[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
