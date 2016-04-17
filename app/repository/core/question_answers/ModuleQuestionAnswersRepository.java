package repository.core.question_answers;

import models.core.question_answers.ModuleIdQuestionsAnswersId;
import models.core.question_answers.ModuleQuestionsAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Repository
public interface ModuleQuestionAnswersRepository extends JpaRepository<ModuleQuestionsAnswers, ModuleIdQuestionsAnswersId> {

}
