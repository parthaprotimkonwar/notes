package models.payments;

import models.users.User;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Embeddable
public class UserIdPaymentId implements Serializable{

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "USER_ID")
    private User userId;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "PAYMENT_ID")
    private Payments paymentId;

    public UserIdPaymentId() {
    }

    public UserIdPaymentId(User userId, Payments paymentId) {
        this.userId = userId;
        this.paymentId = paymentId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Payments getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payments paymentId) {
        this.paymentId = paymentId;
    }
}
