
package net.iqb.persistence;

import java.util.List;

/**
 *
 * @author gershom
 */
public interface BaseDAO<T> {
    
    public Long save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public List<T> findAll();
    public T find(Long id);
    
}
