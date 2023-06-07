package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.data.entity.User;

import java.util.List;

public interface CompanionCustomRepository {
    List<Companion> searchPets(Long id);
    void addOwner(Long id, List<User> owners);
}
