package DO_AN_FIX;

public abstract class User {
    private String role;
    private String username;
    private String password;

    public User(){}
    public User(String username, String password , String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public abstract boolean login(String username, String password);

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
