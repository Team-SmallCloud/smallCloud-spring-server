package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Companion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanionRepository extends JpaRepository<Companion, Long> {
}
