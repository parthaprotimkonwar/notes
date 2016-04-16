package services.service.users;

import application.exceptions.BaseException;

/**
 * Created by pkonwar on 4/16/2016.
 */

public interface UserServiceI {

    /**
     * Checks if the user with the userId is valid
     * @param userId
     * @return
     */
    Boolean isValidLogin(Long userId) throws BaseException;

    /**
     * The user with the combination of emailid phonenumber password deviceId should be valid
     * @param emailId
     * @param phoneNo
     * @param password
     * @param deviceId
     * @return
     */
    Boolean isValidLogin(String emailId, String phoneNo, String password, String deviceId) throws BaseException;
}
