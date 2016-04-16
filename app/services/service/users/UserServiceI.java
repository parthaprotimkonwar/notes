package services.service.users;

import application.exceptions.BaseException;
import models.bean.users.UserBean;
import models.users.User;

/**
 * Created by pkonwar on 4/16/2016.
 */

public interface UserServiceI {

    /**
     * Add a new user
     * @param userBean
     * @return
     */
    User addUser(UserBean userBean) throws BaseException;

    /**
     *
     * @param userBean
     * @return
     * @throws BaseException
     */
    User inactivateUser(UserBean userBean) throws BaseException;

    /**
     * Checks if the user with the userId is valid
     * @param userId
     * @return
     */
    Boolean isValidLogin(Long userId) throws BaseException;

    /**
     * The user with the combination of emailId phoneNumber password deviceId should be valid
     * @param emailId
     * @param phoneNo
     * @param password
     * @param deviceId
     * @return
     */
    Boolean isValidLogin(String emailId, String phoneNo, String password, String deviceId) throws BaseException;
}
