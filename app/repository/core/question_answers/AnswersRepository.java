package repository.core.question_answers;

import models.core.question_answers.Answers;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Answer Repository Class
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long>{
}
