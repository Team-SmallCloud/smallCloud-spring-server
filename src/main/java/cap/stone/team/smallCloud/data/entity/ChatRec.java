package cap.stone.team.smallCloud.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "chat_rec")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRec extends BaseEntity {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User reqUser;
    @ManyToOne(fetch = FetchType.LAZY)
    private User resUser;
    @Column(name = "room_id")
    private String roomId;
    @Column
    private String messages;
    @Column
    private Boolean open;
}
