package repository.core.question_answers;

import models.core.Modules;
import models.core.question_answers.ModuleIdQuestionsAnswersId;
import models.core.question_answers.ModuleQuestionsAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Repository
public interface ModuleQuestionAnswersRepository extends JpaRepository<ModuleQuestionsAnswers, ModuleIdQuestionsAnswersId> {

    List<ModuleQuestionsAnswers> findByModuleIdQuestionsAnswersIdModule(Modules module);

}
