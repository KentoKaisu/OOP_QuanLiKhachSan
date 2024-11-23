import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin();
        Receptionist receptionist = new Receptionist();

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Xin Chào! Hãy nhập tài khoản và mật khẩu của bạn.");
            System.out.print("Nhập tài khoản ở đây: ");
            String username = sc.nextLine();
            System.out.print("Nhập mật khẩu ở đây: ");
            String password = sc.nextLine();

            if (admin.login(username, password)) {
                isLoggedIn = true;
                System.out.println("Xin chào, ADMIN!");

                int luaChon = -1;
                do {
                    System.out.println("\nDanh Sách Lệnh:");
                    System.out.println("0. Thoát chương trình.");
                    System.out.println("1. Kiểm tra phòng trống.");
                    System.out.println("2. Thêm phòng.");
                    System.out.println("3. Xóa phòng.");
                    System.out.println("4. Quản lí nhân viên.");
                    System.out.print("Hãy chọn chức năng: ");

                    luaChon = sc.nextInt();
                    sc.nextLine();

                    switch (luaChon) {
                        case 0:
                            System.out.println("Chương trình đã thoát. Tạm biệt ADMIN!");
                            break;
                        case 1:
                            System.out.println("Đếm số lượng phòng còn trống...");
                            break;
                        case 2:
                            System.out.println("Thêm phòng mới...");
                            break;
                        case 3:
                            System.out.println("Xóa phòng...");
                            break;
                        case 4:
                            admin.manageStaff();
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 4.");
                            break;
                    }
                } while (luaChon != 0);
            } else if (receptionist.login(username, password)) {
                isLoggedIn = true;
                System.out.println("Xin chào, RECEPTIONIST!");
                receptionist.manageBooking();
            } else {
                System.out.println("Tài khoản hoặc mật khẩu không đúng. Vui lòng thử lại.");
            }
        }

        sc.close();
    }
}
