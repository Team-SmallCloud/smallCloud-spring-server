package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User save = userRepository.save(user.toEntity());
        return save.toDto();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User save = userRepository.save(user.toEntity());
        return save.toDto();
    }

    @Override
    public UserDto updateReject(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateSafeMoney(UserDto user) {
        return null;
    }

    @Override
    public void deleteUser(UserDto user) {
        userRepository.delete(user.toEntity());
    }

    @Override
    public UserDto userInfo(UserDto user) {
        User fUser = userRepository.findByNameEqualsAndPhoneEqualsAndEmailEquals(user.getName(), user.getPhone(), user.getEmail());
        return fUser.toDto();
    }
}
