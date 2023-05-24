package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.data.entity.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindRepository extends JpaRepository<Kind, Long> {
    boolean existsById(Kind kind);
    void deleteByCategoryEquals(Category category);
}
