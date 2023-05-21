package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameEqualsAndPhoneEqualsAndEmailEquals(String name, String phone, String email);
    User findByEmailAndAndPassword(String email, String password);
    boolean existsByEmail(String email);
    boolean existsByNameEqualsAndPhoneEqualsAndEmailEquals(String name, String phone, String email);
}
