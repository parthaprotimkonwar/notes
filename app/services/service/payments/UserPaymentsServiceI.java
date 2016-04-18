package services.service.payments;

import application.exceptions.BaseException;
import models.payments.UserPayments;

/**
 * Created by pkonwar on 4/18/2016.
 */
public interface UserPaymentsServiceI {

    UserPayments addUserPayments(Long userId, Long paymentId) throws BaseException;
}
