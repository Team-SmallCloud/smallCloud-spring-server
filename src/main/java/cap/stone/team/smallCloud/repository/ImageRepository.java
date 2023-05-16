package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.ImageTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageTest, Long> {
    ImageTest findByImageUrlContainingAndAndImageInfoEquals(String image_url, String image_info);
}
