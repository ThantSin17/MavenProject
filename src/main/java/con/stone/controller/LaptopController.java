package con.stone.controller;

import con.stone.entity.Laptop;
import con.stone.view.AbstractView;
import con.stone.view.LaptopView;

import java.util.List;

public interface LaptopController<T extends Laptop> extends AbstractView<T> {
    T findById(int id);
    List<T> findAll();

    T save(T model);
    T update(T model);

    void delete(T model);
    void deleteById(int id);
}
