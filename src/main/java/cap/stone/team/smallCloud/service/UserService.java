package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user);
    UserDto updateReject(UserDto user);
    UserDto updateSafeMoney(UserDto user);
    void deleteUser(UserDto user);
    void deleteUserById(Long id);
    UserDto userInfo(UserDto user);
    UserDto loginUser(String uid, String passwd);
    List<UserDto> tempUserList();
}
