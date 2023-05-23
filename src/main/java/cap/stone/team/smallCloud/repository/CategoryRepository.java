package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
