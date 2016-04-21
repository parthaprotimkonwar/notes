package models.payments;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "PAYMENTS", schema = Constants.SCHEMA_NAME_PAYMENTS)
public class Payments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "PAYMENT_GATEWAY_NAME", nullable = false, unique = true, length = 20)
    private String paymentGatewayName;

    @Column(name = "PAYMENT_GATEWAY_PARAMS")
    @Lob
    private String paymentGatewayParams;

    @OneToMany(mappedBy = "userIdPaymentId.paymentId", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<UserPayments> userPayments;

    public Payments() {
    }

    public Payments(String paymentGatewayName, String paymentGatewayParams) {
        this.paymentGatewayName = paymentGatewayName;
        this.paymentGatewayParams = paymentGatewayParams;
    }

    public String getPaymentGatewayName() {
        return paymentGatewayName;
    }

    public void setPaymentGatewayName(String paymentGatewayName) {
        this.paymentGatewayName = paymentGatewayName;
    }

    public String getPaymentGatewayParams() {
        return paymentGatewayParams;
    }

    public void setPaymentGatewayParams(String paymentGatewayParams) {
        this.paymentGatewayParams = paymentGatewayParams;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
