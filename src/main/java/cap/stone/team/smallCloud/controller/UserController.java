package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("signup")
    public UserDto signupUser(UserDto userDto) {
        userDto.invalidCheck();
        userDto.startUserSet();
        UserDto user = userService.createUser(userDto);

        return user;
    }
}
