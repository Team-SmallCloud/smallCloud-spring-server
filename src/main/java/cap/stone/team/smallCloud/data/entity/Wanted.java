package cap.stone.team.smallCloud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "wanted")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wanted extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;
    @Column
    private int watch;
    @Column
    private String content;
    @Column
    private int gratuity;
    @Column
    private LocalDateTime lostDate;
    @Column
    private Double longitude;
    @Column
    private Double latitude;
    @Column
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    private LostPet lostPet;
    @Column
    private Boolean finish;
    @Column
    private Boolean reject;
}
