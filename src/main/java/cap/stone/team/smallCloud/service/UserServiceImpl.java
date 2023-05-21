package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.repository.UserRepository;
import cap.stone.team.smallCloud.utils.exception.FailUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public void deleteUser(UserDto user) {
        userRepository.delete(user.toEntity());
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto userInfo(UserDto user) {
        User fUser = userRepository.findByNameEqualsAndPhoneEqualsAndEmailEquals(user.getName(), user.getPhone(), user.getEmail());
        return fUser.toDto();
    }

    @Override
    public UserDto loginUser(String uid, String passwd) {
        User loginUser = userRepository.findByEmailAndAndPassword(uid, passwd);

        if (loginUser == null) {
            throw new FailUserException("아이디/비밀번호가 틀렸습니다.");
        }
        return loginUser.toDto();
    }

    @Override
    public List<UserDto> tempUserList() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(u -> u.toDto()).collect(Collectors.toList());
    }
}
