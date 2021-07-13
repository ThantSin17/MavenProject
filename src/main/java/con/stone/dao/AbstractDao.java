package con.stone.dao;

import java.util.List;

public interface AbstractDao<T,ID extends Comparable<ID>> {
    T findOne(ID id);
    T save(T entity);
    T update(T entity);

    void delete(T entity);
    void deleteById(ID id);

    List<T> findAll();
}
