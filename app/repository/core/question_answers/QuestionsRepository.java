package repository.core.question_answers;

import models.core.question_answers.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * QuestionsRepository
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>{
}
