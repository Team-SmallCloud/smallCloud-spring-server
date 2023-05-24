package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import cap.stone.team.smallCloud.data.dto.KindDto;

import java.util.List;

public interface KindService {
    KindDto createKind(KindDto kind);
    KindDto updateKind(KindDto kind);
    KindDto searchId(Long id);
    List<KindDto> searchKind(KindDto kind);
    void deleteKind(KindDto kind);
    void categoryDeleted(CategoryDto category);
}
