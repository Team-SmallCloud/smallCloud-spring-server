package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.vo.type.Board;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
public class Comment {
    @Id
    private Long id;
    private Board board;
    private Long to_content_id;
    private Long to_comment_id;
    @OneToOne
    private User commenter;
    private String content;
    private LocalDate post_date;
    private LocalDate mod_date;
    private Boolean reject;
}
