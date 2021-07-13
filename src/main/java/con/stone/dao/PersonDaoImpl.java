package con.stone.dao;

import con.stone.dao.AbstractDaoImpl;
import con.stone.entity.Person;
import con.stone.repository.PersonRepository;

import java.util.List;

public class PersonDaoImpl extends AbstractDaoImpl<Person,Integer> implements PersonRepository {
    public PersonDaoImpl(){
        super();
    }

    @Override
    public Person findOne(Integer integer) {
        return super.findOne(integer);
    }

    @Override
    public Person save(Person entity) {
        return super.save(entity);
    }

    @Override
    public List<Person> findAll() {
        return super.findAll();
    }
}
