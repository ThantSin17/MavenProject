package con.stone.dao;

import java.util.List;

public interface AbstractDao<T> {
    T save(T entity);
    List<T> findAll();
}
