package cap.stone.team.smallCloud.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

//@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String password;
    private Boolean reject;
    private int safe;
}
