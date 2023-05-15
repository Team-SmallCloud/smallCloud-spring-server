package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.dto.ImageFind;
import cap.stone.team.smallCloud.data.dto.ImageTestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageTest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "image_info")
    private String imageInfo;
    @Column(name = "image_url")
    private String imageUrl;

    public ImageFind toDto() {
        return ImageFind.builder()
                .fileName(imageUrl)
                .imageInfo(imageInfo)
                .build();
    }
}
