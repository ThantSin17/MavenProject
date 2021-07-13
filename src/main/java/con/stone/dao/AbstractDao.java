package con.stone.dao;

import java.util.List;

public interface AbstractDao<T,ID extends Comparable<ID>> {
    T findOne(ID id);
    T save(T entity);
    List<T> findAll();
}
