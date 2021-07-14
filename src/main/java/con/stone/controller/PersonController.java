package con.stone.controller;

import con.stone.entity.Person;
import con.stone.view.AbstractView;

import java.util.List;

public interface PersonController<T extends Person> extends AbstractView<T> {
    T findById(int id);
    List<T> findAll();

    T save(T model);
    T update(T model);

    void delete(T model);
    void deleteById(int id);
}

