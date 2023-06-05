package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.repository.CompanionRepository;
import cap.stone.team.smallCloud.utils.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        List<Companion> companions = companionRepository.searchPets(user.getId());

        return companions.stream().map(Companion::toDto).collect(Collectors.toList());
    }

    @Override
    public CompanionDto addPets(CompanionDto companionDto) {
        return companionRepository.save(companionDto.toEntity()).toDto();
    }

    @Transactional
    @Override
    public CompanionDto editPets(CompanionDto companionDto) {
        if (companionRepository.existsById(companionDto.getId())) {
            return companionRepository.save(companionDto.toEntity()).toDto();
        }
        throw new EntityNotFoundException("수정할 펫이 없습니다.");
    }

    @Transactional
    @Override
    public void deleteCompanion(CompanionDto companionDto) {
        companionRepository.delete(companionDto.toEntity());
    }

    @Transactional
    @Override
    public void deleteCompanionByOwner(Long id) {
        companionRepository.deleteByOwner(id);
    }
}
