package cap.stone.team.smallCloud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "image_info")
    private String imageInfo;
    @Column(name = "image_url")
    private String imageUrl;

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;
}
