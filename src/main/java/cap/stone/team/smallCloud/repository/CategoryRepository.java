package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameLike(String name);
    Category findByNameEquals(String name);
    void deleteByNameEquals(String name);
}
