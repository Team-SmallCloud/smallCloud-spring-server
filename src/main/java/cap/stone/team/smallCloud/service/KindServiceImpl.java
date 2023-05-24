package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import cap.stone.team.smallCloud.data.dto.KindDto;
import cap.stone.team.smallCloud.data.entity.Kind;
import cap.stone.team.smallCloud.repository.KindRepository;
import cap.stone.team.smallCloud.repository.SearchKindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KindServiceImpl implements KindService {
    private final KindRepository kindRepository;
    private final SearchKindRepository searchKindRepository;

    @Override
    public KindDto createKind(KindDto kind) {
        return kindRepository.save(kind.toEntity()).toDto();
    }

    @Transactional
    @Override
    public KindDto updateKind(KindDto kind) {
        if (kindRepository.existsById(kind.toEntity())) {
            return kindRepository.save(kind.toEntity()).toDto();
        }
        throw new EntityExistsException();
    }

    @Override
    public KindDto searchId(Long id) {
        return kindRepository.findById(id).orElseThrow().toDto();
    }

    @Override
    public List<KindDto> searchKind(KindDto kind) {
        return searchKindRepository.findKindBySql(kind).stream().map(Kind::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteKind(KindDto kind) {
        kindRepository.delete(kind.toEntity());
    }

    @Override
    public void categoryDeleted(CategoryDto category) {
        kindRepository.deleteByCategoryEquals(category.toEntity());
    }
}
