package repository.users;

import models.users.UserChapters;
import models.users.UserIdChapterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Repository
public interface UserChaptersRepository extends JpaRepository<UserChapters, UserIdChapterId>{
}
