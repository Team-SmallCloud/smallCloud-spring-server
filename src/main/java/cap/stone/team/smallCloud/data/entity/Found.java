package cap.stone.team.smallCloud.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
public class Found {
    @Id
    private Long id;
    private String title;
    @ManyToOne
    private User writer;
    private int watch;
    private String content;
    private LocalDate post_date;
    private LocalDate mod_date;
    private LocalDate found_date;
    // 데이터의 상태에 따라 변경가능
    private Double longitude;
    private Double latitude;
    //
    private String address;
    @ManyToOne
    private LostPet lostPet;
    private Boolean finish;
    private Boolean reject;
}
