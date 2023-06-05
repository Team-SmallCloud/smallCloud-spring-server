package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Companion;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static cap.stone.team.smallCloud.data.entity.QCompanion.companion;
import static cap.stone.team.smallCloud.data.entity.QUser.user;

public class CompanionRepositoryImpl implements CompanionCustomRepository {
    private final JPAQueryFactory queryFactory;

    public CompanionRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Companion> searchPets(Long id) {
        return queryFactory
                .select(companion)
                .from(companion)
                .where(
                        companion.owner.contains(
                                queryFactory.select(user)
                                        .from(user)
                                        .where(user.id.eq(id))
                                )
                )
                .fetch();
    }

    @Override
    public Companion addOwner(Long id, List<Long> ownerIds) {
        return null;
    }
}
