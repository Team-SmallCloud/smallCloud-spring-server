package cap.stone.team.smallCloud.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

//@Entity
public class ChatRec {
    @Id
    private Long id;
    private User request;
    private User response;
    private String messages;
    private LocalDate start_date;
    private LocalDate end_date;
    private Boolean open;
}
