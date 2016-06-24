package repository.core;

import models.core.Chapters;
import models.core.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface ModulesRepository extends JpaRepository<Modules, Long> {

    Modules findByChapterAndModuleName(Chapters chapter, String moduleName);
}
