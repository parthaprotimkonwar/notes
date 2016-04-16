package repository.core;

import models.core.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Long>{
}
