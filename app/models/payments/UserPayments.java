package models.payments;

import models.Constants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "USER_PAYMENTS", schema = Constants.SCHEMA_NAME_PAYMENTS)
public class UserPayments implements Serializable{

    @EmbeddedId
    private UserIdPaymentId userIdPaymentId;

    public UserPayments() {
    }

    public UserPayments(UserIdPaymentId userIdPaymentId) {
        this.userIdPaymentId = userIdPaymentId;
    }

    public UserIdPaymentId getUserIdPaymentId() {
        return userIdPaymentId;
    }

    public void setUserIdPaymentId(UserIdPaymentId userIdPaymentId) {
        this.userIdPaymentId = userIdPaymentId;
    }
}
