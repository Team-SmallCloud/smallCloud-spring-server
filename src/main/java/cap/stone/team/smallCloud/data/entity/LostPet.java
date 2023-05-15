package cap.stone.team.smallCloud.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "lost_pet")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LostPet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Companion companion;
    @Column
    private Boolean found;
}
