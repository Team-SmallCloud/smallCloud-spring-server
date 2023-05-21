package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.utils.exception.EmptyUserDataException;
import cap.stone.team.smallCloud.utils.exception.UserDataInvalidException;
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

    public void inputInvalidCheck() {
        if (name.length() <= 0) {
            throw new EmptyUserDataException("이름을 입력해 주세요.");
        }

        if (phone.length() <= 0) {
            throw new EmptyUserDataException("휴대전화 번호를 입력해 주세요.");
        }

        if (email.length() <= 0) {
            throw new EmptyUserDataException("이메일을 입력해 주세요.");
        } else {
            if (!email.matches("/(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))/")) {
                throw new UserDataInvalidException("이메일 형식이 틀렸습니다.");
            }
        }

        if (password.length() <= 0) {
            throw new EmptyUserDataException("비밀번호를 입력해 주세요.");
        } else {
            pwInvalidCheck();
        }
    }

    private void pwInvalidCheck() {
        if (password.length() >= 8) {
            if (password.matches("/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])/")) {
                throw new UserDataInvalidException("영어 대소문자와 숫자가 필요합니다.");
            }
            else {
                if (password.matches("/^(?=.*?[#?!@$ %^&*-])/")) {
                    throw new UserDataInvalidException("특수문자가 포함되어 있지 않습니다.");
                }
            }
        }
        else {
            throw new UserDataInvalidException("비밀번호 길이가 8자 이하입니다.");
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
