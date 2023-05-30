package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CompanionDto;
import cap.stone.team.smallCloud.data.entity.Companion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pets")
@RestController
@RequiredArgsConstructor
public class PetController {

    @GetMapping
    public List<CompanionDto> allCompanion() {
        return null;
    }
}
