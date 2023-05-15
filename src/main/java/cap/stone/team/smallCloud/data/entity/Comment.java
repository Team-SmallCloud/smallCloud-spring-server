package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.vo.type.Board;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Board board;
    @Column
    private Long to_content_id; // board의 값에 따라 조인 조건이 갈림
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment to_comment_id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User commenter;
    @Column
    private String content;
    @Column
    private Boolean reject;
}
