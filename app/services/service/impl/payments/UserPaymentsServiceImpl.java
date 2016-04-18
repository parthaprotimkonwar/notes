package services.service.impl.payments;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.payments.Payments;
import models.payments.UserIdPaymentId;
import models.payments.UserPayments;
import models.users.User;
import repository.payments.PaymentsRepository;
import repository.payments.UserPaymentsRepository;
import repository.users.UserRepository;
import services.service.payments.UserPaymentsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/18/2016.
 */
@Named
@Singleton
public class UserPaymentsServiceImpl implements UserPaymentsServiceI {

    @Inject
    UserRepository userRepository;
    @Inject
    PaymentsRepository paymentsRepository;
    @Inject
    UserPaymentsRepository userPaymentsRepository;

    @Override
    public UserPayments addUserPayments(Long userId, Long paymentId) throws BaseException {
        try {
            User user = userRepository.findOne(userId);
            Payments payments = paymentsRepository.findOne(paymentId);

            UserIdPaymentId userIdPaymentId = new UserIdPaymentId(user, payments);
            UserPayments userPayments = new UserPayments(userIdPaymentId);
            return userPaymentsRepository.save(userPayments);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
