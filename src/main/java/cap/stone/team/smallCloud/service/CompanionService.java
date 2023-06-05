package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;

import java.util.List;

public interface CompanionService {
    List<CompanionDto> allPets();
    List<CompanionDto> allUsersPets(UserDto user);
    CompanionDto addPets(CompanionDto companionDto);
    CompanionDto editPets(CompanionDto companionDto);
    void deleteCompanion(CompanionDto companionDto);
    void deleteCompanionByOwner(Long id);
}