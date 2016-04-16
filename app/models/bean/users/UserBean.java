package models.bean.users;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserBean implements Serializable{

    public UserBean(Long userId) {
        this.userId = userId;
    }

    public UserBean(Long userId, String userName, String emailId, String phoneNo, String password, String deviceId) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.password = password;
        this.deviceId = deviceId;
    }

    private Long userId;
    private String userName;
    private String emailId;
    private String phoneNo;
    private String password;
    private String deviceId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
