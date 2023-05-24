package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.dto.KindDto;
import cap.stone.team.smallCloud.data.entity.Kind;
import cap.stone.team.smallCloud.data.entity.QCategory;
import cap.stone.team.smallCloud.data.entity.QKind;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchKindRepository extends QuerydslRepositorySupport {
    @PersistenceContext
    private EntityManager entityManager;

    private final QKind kind = QKind.kind;
    private final QCategory category = QCategory.category;

    public SearchKindRepository() {
        super(Kind.class);
    }

    public List<Kind> findKindBySql(KindDto kindDto) {
        return jpaQueryInit().where(
                kind.category.id.eq(category.id)
                        .and(kindDto.getCategoryId() != null ? kind.category.id.eq(kindDto.getCategoryId()) : null)
                        .and(kindDto.getSpecies().isEmpty() ? null : kind.species.eq(kindDto.getSpecies()))
                        .and(kindDto.getShape().isEmpty() ? null : kind.shape.eq(kindDto.getShape()))
                        .and(kindDto.getSize() != null ? kind.size.eq(kindDto.getSize()) : null)
        ).fetch();
    }

    private JPAQuery<Kind> jpaQueryInit() {
        return new JPAQuery<>(entityManager).from(kind).select(kind);
    }
}
