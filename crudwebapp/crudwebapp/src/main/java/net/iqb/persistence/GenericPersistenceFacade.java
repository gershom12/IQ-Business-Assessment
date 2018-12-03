package net.iqb.persistence;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gershom This is the persistence layer to which all services to be
 * defined in the service layer extends in order to inherit the generic crud
 * functionalities.
 */
@Repository
@Transactional
public abstract class GenericPersistenceFacade<T> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate hibernateTemplate;

    private final Class<T> entityClass;

    public GenericPersistenceFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public Long save(T entity) {
        return (Long) hibernateTemplate.save(entity);
    }

    @Override
    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }
    @Override
    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    @Override
    public List<T> findAll() {
        return hibernateTemplate.loadAll(entityClass);
    }

    @Override
    public T find(Long id) {
        return (T) hibernateTemplate.load(entityClass, id);
    }

}
