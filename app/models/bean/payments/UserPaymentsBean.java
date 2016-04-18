package models.bean.payments;

import models.Constants;
import models.payments.UserIdPaymentId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserPaymentsBean implements Serializable{

    private Long userId;

    private Long paymentsId;

    public UserPaymentsBean(Long userId, Long paymentsId) {
        this.userId = userId;
        this.paymentsId = paymentsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPaymentsId() {
        return paymentsId;
    }

    public void setPaymentsId(Long paymentsId) {
        this.paymentsId = paymentsId;
    }
}
