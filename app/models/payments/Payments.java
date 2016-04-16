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
public class Payments implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "PAYMENT_GATEWAY_PARAMS")
    @Lob
    private String paymentGatewayParams;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdPaymentId.paymentId")
    private Set<UserPayments> userPayments;
}
