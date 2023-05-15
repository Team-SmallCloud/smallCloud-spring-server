package cap.stone.team.smallCloud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "found")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Found {
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
    @Column(name = "found_date")
    private LocalDateTime foundDate;
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
