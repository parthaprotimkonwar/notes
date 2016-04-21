package models.users;

import models.Constants;
import application.enums.STATUS;
import models.payments.UserPayments;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "USER", schema = Constants.SCHEMA_NAME_USER)
public class User implements Serializable {

    public User() {
    }

    public User(String userName, String emailId, String phoneNo, String password, String deviceId, STATUS status) {
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.password = password;
        this.deviceId = deviceId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME", length = 30)
    private String userName;

    @Column(name = "EMAIL_ID", length = 30, unique = true, nullable = false)
    private String emailId;

    @Column(name = "PHONE_NO", length = 15)
    private String phoneNo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "DEVICE_ID", length = 100, unique = true, nullable = false)
    private String deviceId;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(mappedBy = "userIdChapterId.userId", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<UserChapters> userChapters;

    @OneToMany(mappedBy = "userIdPaymentId.userId", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<UserPayments> userPayments;

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

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
