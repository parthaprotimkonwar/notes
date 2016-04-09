package models.users;

import models.payments.UserPayments;
import utilities.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "USER", schema = Constants.SCHEMA_NAME_USER)
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdChapterId.userId")
    private Set<UserChapters> userChapters;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdPaymentId.userId")
    private Set<UserPayments> userPayments;
}
