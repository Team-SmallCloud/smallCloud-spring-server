package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.utils.exception.EmptyUserDataException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String phone;
    private String email;
    private String password;
    private Boolean reject;
    private int safeMoney;

    public void startUserSet() {
        reject = false;
        safeMoney = 0;
    }

    public void rejectUser() {
        reject = true;
    }

    public void userMoney(Long id, int money) {
        this.id = id;
        safeMoney = money;
    }

    public void invalidCheck() {
        if (name.length() <= 0) {
            throw new EmptyUserDataException("no name data insert");
        }

        if (phone.length() <= 0) {
            throw new EmptyUserDataException("no phone number data insert");
        }

        if (email.length() <= 0) {
            throw new EmptyUserDataException("no email data insert");
        }

        if (password.length() <= 0) {
            throw new EmptyUserDataException("no password data insert");
        }
    }

    public User toEntity() {
        return User.builder()
                .birthday(birthday)
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .reject(reject)
                .safeMoney(safeMoney)
                .build();
    }
}
