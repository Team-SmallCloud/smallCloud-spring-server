package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.service.CompanionService;
import cap.stone.team.smallCloud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CompanionService companionService;

    @GetMapping("users")
    public List<UserDto> testUserList() {
        return userService.tempUserList();
    }

    @PostMapping("signup")
    public UserDto signupUser(UserDto userDto) {
        userDto.inputInvalidCheck();
        userDto.startUserSet();
        UserDto user = userService.createUser(userDto);

        return user;
    }

    @PutMapping("edit")
    public UserDto editUser(UserDto userDto) {
        userDto.inputInvalidCheck();
        userDto.startUserSet();
        UserDto user = userService.updateUser(userDto);

        return user;
    }

    @GetMapping("login")
    public UserDto loginUser(@RequestParam String email, @RequestParam String password) {
        UserDto userDto = userService.loginUser(email, password);
        return userDto;
    }

    @DeleteMapping("out")
    public String userWithdrawal(@RequestParam Long id) {
        UserDto userDto = userService.userInfo(id);

        petsDeleteOrUpdates(id, userDto);
        userService.deleteUserById(id);
        return "delete complete";
    }

    private void petsDeleteOrUpdates(Long id, UserDto ud) {
        List<CompanionDto> allCompanionDto = companionService.allUsersPets(ud);
        for (CompanionDto cd : allCompanionDto) {
            petsDeleteOrUpdate(cd, id);
        }
    }

    private void petsDeleteOrUpdate(CompanionDto cd, Long id) {
        if (cd.getOwnerIds().size() <= 1) {
            companionService.deleteCompanion(cd);
        }
        else {
            companionService.addPetOwners(cd.getId(), cd.getOwnerIds());
        }
    }
}
