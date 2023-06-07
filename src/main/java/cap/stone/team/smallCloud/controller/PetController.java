package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.dto.UserDto;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.service.CompanionService;
import cap.stone.team.smallCloud.service.UserService;
import cap.stone.team.smallCloud.utils.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pets")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final CompanionService companionService;
    private final UserService userService;

    @GetMapping
    public List<CompanionDto> allCompanion() {
        return companionService.allPets();
    }

    @GetMapping("/myowns")
    public List<CompanionDto> allPets(Long id) {
        UserDto user = userService.userInfo(id);

        return companionService.allUsersPets(user);
    }

    @PostMapping("/myowns/add")
    public CompanionDto addPets(CompanionDto companionDto) {
        return companionService.addPets(companionDto);
    }

    @PutMapping("/myowns/edit")
    public CompanionDto editPets(CompanionDto companionDto) {
        return companionService.editPets(companionDto);
    }

    @PutMapping("/myowns/owner")
    public CompanionDto addPetsOwner(Long id, Long addId) {
        UserDto user = userService.userInfo(addId);

        List<Long> petOwners = companionService.petsOwners(id);
        if (petOwners.contains(user.getId())) {
            throw new EntityExistsException("이미 사용자가 추가되어 있습니다.");
        }
        else {
            petOwners.add(user.getId());
            companionService.addPetOwners(id, petOwners);
            return companionService.petCheck(id);
        }
    }

    @PutMapping("/myowns/nomore")
    public CompanionDto delPetsOwner(Long id, Long addId) {
        UserDto user = userService.userInfo(addId);

        List<Long> petOwners = companionService.petsOwners(id);
        if (petOwners.contains(user.getId())) {
            petOwners.remove(user.getId());
            companionService.addPetOwners(id, petOwners);
            return companionService.petCheck(id);
        }
        else {
            throw new EntityNotFoundException("사용자가 이미 없습니다.");
        }
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
