package repository.core;

import models.core.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long>{
}
