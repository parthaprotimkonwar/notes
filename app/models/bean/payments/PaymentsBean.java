package models.bean.payments;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class PaymentsBean implements Serializable{

    public PaymentsBean(String paymentGatewayName, String paymentGatewayParams) {
        this.paymentGatewayName = paymentGatewayName;
        this.paymentGatewayParams = paymentGatewayParams;
    }

    private Long paymentId;

    private String paymentGatewayName;

    private String paymentGatewayParams;


    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
}
