package repository.core.question_answers;

import models.core.question_answers.QuestionOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/18/2016.
 */
@Repository
public interface QuestionOptionsRepository extends JpaRepository<QuestionOptions, Long>{
}
