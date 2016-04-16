package services.service.impl.users;

import models.users.User;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import repository.users.UserRepository;
import services.service.users.UserServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Named
@Singleton
public class UserServiceImpl implements UserServiceI{

    @Inject
    private UserRepository userRepository;

    @Override
    public Boolean isValidLogin(Long userId) throws BaseException {
        User user = null;
        try {
            user = userRepository.findOne(userId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
        return user != null && user.getUserId() != null ? true : false;
    }

    @Override
    public Boolean isValidLogin(String emailId, String phoneNo, String password, String deviceId) throws BaseException {
        User user = null;
        try {
            user = userRepository.findByEmailIdAndPhoneNoAndPasswordAndDeviceId(emailId, phoneNo, password, deviceId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
        return user != null && user.getUserId() != null ? true : false;
    }
}
