package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user);
    UserDto updateReject(UserDto user);
    UserDto updateSafeMoney(UserDto user);
    void deleteUser(UserDto user);
    UserDto userInfo(UserDto user);
}
