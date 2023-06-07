package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.User;

import java.util.List;

public interface CompanionService {
    List<CompanionDto> allPets();
    List<CompanionDto> allUsersPets(UserDto user);
    CompanionDto petCheck(Long id);
    List<CompanionDto> petsSearch(CompanionDto companionDto);
    List<Long> petsOwners(Long id);
    CompanionDto addPets(CompanionDto companionDto);
    CompanionDto editPets(CompanionDto companionDto);
    CompanionDto addPetOwners(Long id, List<Long> addOwners);
    void deleteCompanion(CompanionDto companionDto);
    void deleteCompanionByOwner(Long id);
}
