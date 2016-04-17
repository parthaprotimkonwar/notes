package repository.core.question_answers;

import models.core.question_answers.ModuleIdQuestionIdAnswerId;
import models.core.question_answers.ModuleQuestionsAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ModuleQuestionsRepository
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface ModuleQuestionsRepository extends JpaRepository<ModuleQuestionsAnswer, ModuleIdQuestionIdAnswerId>{
}
