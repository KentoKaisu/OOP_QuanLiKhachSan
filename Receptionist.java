public class Receptionist extends User{
    public Receptionist() {
        super("receptionist", "12345" , "RECEPTIONIST");
    }

    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }

    // quản lí đặt phòng
    public void manageBooking() {
        System.out.println("Managing bookings...");
    }
}
