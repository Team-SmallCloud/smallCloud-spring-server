package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.repository.CompanionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanionServiceImpl implements CompanionService {
    private final CompanionRepository companionRepository;

    @Override
    public List<CompanionDto> allPets() {
        return companionRepository.findAll().stream().map(Companion::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CompanionDto> allUsersPets(UserDto user) {
        Optional<Companion> ids = companionRepository.findById(user.getId());
        if (.isPresent()) {
            return companionRepository
        }
    }

    @Override
    public CompanionDto addPets(CompanionDto companionDto) {
        return null;
    }

    @Override
    public CompanionDto editOwners(List<Long> ids) {
        return null;
    }

    @Override
    public CompanionDto editPets(CompanionDto companionDto) {
        return null;
    }

    @Override
    public void deleteOwner(Long id) {

    }

    @Override
    public void deleteCompanion(CompanionDto companionDto) {

    }
}
