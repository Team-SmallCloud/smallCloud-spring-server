package cap.stone.team.smallCloud.repository;

import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.data.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static cap.stone.team.smallCloud.data.entity.QCompanion.companion;
import static cap.stone.team.smallCloud.data.entity.QUser.user;

@Repository
public class CompanionCustomRepositoryImpl implements CompanionCustomRepository {
    private final JPAQueryFactory queryFactory;
    @PersistenceContext
    private final EntityManager em;

    public CompanionCustomRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(this.em);
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

    @Transactional
    @Override
    public void addOwner(Long id, List<User> owners) {
        queryFactory.update(companion)
                .where(companion.id.eq(id))
                .set(companion.owner, owners)
                .execute();

        em.clear();
        em.flush();
    }
}

