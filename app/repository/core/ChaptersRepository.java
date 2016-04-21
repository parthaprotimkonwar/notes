package repository.core;

import models.core.Chapters;
import models.core.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Long> {

    List<Chapters> findBySubject(Subjects subject);
}
