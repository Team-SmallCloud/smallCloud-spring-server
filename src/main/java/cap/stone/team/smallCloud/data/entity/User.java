package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "birth_day")
    private LocalDate birthday;
    @Column
    private String phone;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private Boolean reject;
    @Column(name = "safe_money")
    private int safeMoney;
    @Column
    private String juso;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .birthday(birthday)
                .email(email)
                .name(name)
                .password(password)
                .phone(phone)
                .reject(reject)
                .safeMoney(safeMoney)
                .juso(juso)
                .build();
    }
}
