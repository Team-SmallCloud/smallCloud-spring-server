package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.repository.CompanionCustomRepository;
import cap.stone.team.smallCloud.repository.CompanionRepository;
import cap.stone.team.smallCloud.utils.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanionServiceImpl implements CompanionService {
    private final CompanionRepository companionRepository;
    private final CompanionCustomRepository companionCustomRepository;

    @Override
    public List<CompanionDto> allPets() {
        return companionRepository.findAll().stream().map(Companion::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CompanionDto> allUsersPets(UserDto user) {
        List<Companion> companions = companionCustomRepository.searchPets(user.getId());

        return companions.stream().map(Companion::toDto).collect(Collectors.toList());
    }

    @Override
    public CompanionDto petCheck(Long id) {
        Optional<Companion> pet = companionRepository.findById(id);

        if (pet.isPresent()) {
            return pet.get().toDto();
        }
        throw new EntityNotFoundException("조회된 펫이 없습니다.");
    }

    @Override
    public List<CompanionDto> petsSearch(CompanionDto companionDto) {
        return null;
    }

    @Override
    public List<Long> petsOwners(Long id) {
        Optional<Companion> pet = companionRepository.findById(id);
        if (pet.isPresent()) {
            return pet.get().toDto().getOwnerIds();
        }
        throw new EntityNotFoundException("조회된 펫이 없습니다.");
    }

    @Override
    public CompanionDto addPets(CompanionDto companionDto) {
        return companionRepository.save(companionDto.toEntity()).toDto();
    }

    @Override
    public CompanionDto editPets(CompanionDto companionDto) {
        if (companionRepository.existsById(companionDto.getId())) {
            return companionRepository.save(companionDto.toEntity()).toDto();
        }
        throw new EntityNotFoundException("수정할 펫이 없습니다.");
    }

    @Override
    public CompanionDto addPetOwners(Long id, List<Long> addOwners) {
        Optional<Companion> pet = companionRepository.findById(id);
        if (pet.isPresent()) {
            CompanionDto companionDto = pet.get().toDto();
            companionDto.setOwnerIds(addOwners);
            return companionRepository.save(companionDto.toEntity()).toDto();
        }
        throw new EntityNotFoundException("조회한 펫이 없습니다.");
//        companionCustomRepository.addOwner(id, addOwners);
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
