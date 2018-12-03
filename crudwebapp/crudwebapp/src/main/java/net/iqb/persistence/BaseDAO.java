package net.iqb.persistence;

import java.util.List;

/**
 *
 * @author gershom This is the generic interface which must be inherited by all
 * services that will be defined in the service layer.
 */
public interface BaseDAO<T> {

    public Long save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public List<T> findAll();

    public T find(Long id);
}
