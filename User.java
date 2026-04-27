public class User {
    private String userName;
    private String userId;
    private String password;
    private String fullName;
    private String contact;

    public User(String userName, String userId, String fullName, String contact) {
        this.userName = userName;
        this.userId = userId;
        this.password=password;
        this.fullName = fullName;
        this.contact = contact;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return fullName + "("+userName+")";
    }
}
