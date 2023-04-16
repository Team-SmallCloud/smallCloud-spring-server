package cap.stone.team.smallCloud.data.entity;

import javax.persistence.*;

//@Entity
public class LostPet {
    @Id
    private Long id;
    @OneToOne
    private Companion companion;
    private Boolean found;
}
