package repository.core;

import models.core.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long>{
}
