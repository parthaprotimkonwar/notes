package repository.users;

import models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmailIdAndPhoneNoAndPasswordAndDeviceId(String emailId, String phoneNo, String password, String deviceId);
}
