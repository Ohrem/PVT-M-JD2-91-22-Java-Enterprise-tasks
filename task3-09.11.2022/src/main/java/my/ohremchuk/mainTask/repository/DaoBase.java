package my.ohremchuk.mainTask.repository;
import lombok.RequiredArgsConstructor;
import my.ohremchuk.mainTask.entity.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class DaoBase<K extends Serializable, E extends BaseEntity<K>> implements Dao<K,E> {
    private final EntityManager entityManager;
    private final Class<E> clazz;

    @Override
    public E save(E entity) {
       entityManager.persist(entity);
       entityManager.refresh(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(id);
        entityManager.flush();
    }

    @Override
    public void update(E entity) {
       entityManager.merge(entity);
       entityManager.refresh(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        var criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return entityManager.createQuery(criteria)
                .getResultList();
    }
}
