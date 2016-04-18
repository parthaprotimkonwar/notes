package services.service.impl.payments;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.payments.PaymentsBean;
import models.payments.Payments;
import repository.payments.PaymentsRepository;
import services.service.payments.PaymentsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/18/2016.
 */
@Named
@Singleton
public class PaymentsServiceImpl implements PaymentsServiceI{

    @Inject
    PaymentsRepository paymentsRepository;

    @Override
    public Payments insertIntoPayments(PaymentsBean paymentsBean) throws BaseException {
        try {
            Payments payments = new Payments(paymentsBean.getPaymentGatewayName(), paymentsBean.getPaymentGatewayParams());
            return paymentsRepository.save(payments);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Payments updatePayments(PaymentsBean paymentsBean) throws BaseException {
        try {
            Payments payments = paymentsRepository.findOne(paymentsBean.getPaymentId());
            if(Util.notNull(paymentsBean.getPaymentGatewayParams()))
                payments.setPaymentGatewayParams(paymentsBean.getPaymentGatewayParams());
            return paymentsRepository.save(payments);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Payments findPayment(Long paymentId) throws BaseException {
        try {
            return paymentsRepository.findOne(paymentId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Payments> findAllPayments() throws BaseException {
        try {
            return paymentsRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
