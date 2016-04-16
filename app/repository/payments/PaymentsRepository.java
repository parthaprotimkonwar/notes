package repository.payments;

import models.payments.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long>{
}
