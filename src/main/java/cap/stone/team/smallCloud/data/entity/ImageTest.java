package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.dto.ImageFind;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public ImageFind toAllDto() {
        return ImageFind.builder()
                .id(id)
                .fileName(imageUrl)
                .imageInfo(imageInfo)
                .build();
    }
}
