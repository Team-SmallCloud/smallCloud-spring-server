package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.repository.UserRepository;
import cap.stone.team.smallCloud.utils.exception.FailUserException;
import cap.stone.team.smallCloud.utils.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    @Transactional
    @Override
    public UserDto updateUser(UserDto user) {
        if (userRepository.existsById(user.getId())) {
            User save = userRepository.save(user.toEntity());
            return save.toDto();
        }
        throw new EntityNotFoundException("사용자가 없습니다.");
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
    public UserDto userInfo(Long id) {
        Optional<User> userId = userRepository.findById(id);

        if (userId.isPresent()) {
            return userId.get().toDto();
        }
        throw new EntityNotFoundException("일치하는 회원이 없습니다.");
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
