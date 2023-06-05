package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.repository.UserRepository;
import cap.stone.team.smallCloud.service.CompanionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pets")
@RestController
@RequiredArgsConstructor
public class PetController {
    private final CompanionService companionService;
    private final UserRepository userRepository;

    @GetMapping
    public List<CompanionDto> allCompanion() {
        return companionService.allPets();
    }

    @GetMapping("/myowns")
    public List<CompanionDto> allPets(Long id) {
        Optional<User> byId = userRepository.findById(id);

        return byId.map(user -> companionService.allUsersPets(user.toDto())).orElse(null);
    }

    @PostMapping("/myowns/add")
    public CompanionDto addPets(CompanionDto companionDto) {
        return companionService.addPets(companionDto);
    }

    @PutMapping("/myowns/edit")
    public CompanionDto editPets(CompanionDto companionDto) {
        return companionService.editPets(companionDto);
    }

    @DeleteMapping("/myowns/remove")
    public String removePets(CompanionDto companionDto) {
        companionService.deleteCompanion(companionDto);
        return "delete well";
    }

    @DeleteMapping("/myowns/remove/{id}")
    public String removePetsByOwners(@PathVariable Long id) {
        companionService.deleteCompanionByOwner(id);
        return "delete well";
    }
}
