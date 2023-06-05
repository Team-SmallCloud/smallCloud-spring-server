package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Companion;

import java.util.List;

public interface CompanionCustomRepository {
    List<Companion> searchPets(Long id);
    Companion addOwner(Long id, List<Long> ownerIds);
}
