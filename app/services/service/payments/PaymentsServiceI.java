package services.service.payments;

import application.exceptions.BaseException;
import models.bean.payments.PaymentsBean;
import models.payments.Payments;

import java.util.List;

/**
 * Created by pkonwar on 4/18/2016.
 */
public interface PaymentsServiceI {

    /**
     * Insert a new record in Payments
     * @param paymentsBean
     * @return
     * @throws BaseException
     */
    Payments insertIntoPayments(PaymentsBean paymentsBean) throws BaseException;

    /**
     * Update a new payment.
     * Only updates the paymentGatewayParams field
     * @param paymentsBean
     * @return
     * @throws BaseException
     */
    Payments updatePayments(PaymentsBean paymentsBean) throws BaseException;

    /**
     * Find a particular payment record.
     * @param paymentId
     * @return
     * @throws BaseException
     */
    Payments findPayment(Long paymentId) throws BaseException;

    /**
     * Find all payments
     * @return
     * @throws BaseException
     */
    List<Payments> findAllPayments() throws BaseException;
}
