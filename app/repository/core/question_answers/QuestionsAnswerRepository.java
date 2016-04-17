package repository.core.question_answers;

import models.core.question_answers.QuestionsAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * QuestionsAnswerRepository
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface QuestionsAnswerRepository extends JpaRepository<QuestionsAnswer, Long>{
}
