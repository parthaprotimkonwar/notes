package repository.payments;

import models.payments.UserIdPaymentId;
import models.payments.UserPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface UserPaymentsRepository extends JpaRepository<UserPayments, UserIdPaymentId>{
}
