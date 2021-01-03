package jdbc.vo;

public class UserVO {


    private String account;
    private String email;
    private String status;
    private String phoneNumber;

    public UserVO() {}

    public UserVO(String account, String email, String status, String phoneNumber) {
        this.account = account;
        this.email = email;
        this.status = status;
        this.phoneNumber = phoneNumber;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //@Override
    public String toString() {
        return "User [account=" + account + ", email=" + email + ", phone="
                + phoneNumber + ", status=" + status + "]";
    }
}
