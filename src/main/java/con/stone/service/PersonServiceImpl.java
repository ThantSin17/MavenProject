package con.stone.service;

import con.stone.dto.PersonDto;
import con.stone.entity.Person;
import con.stone.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService{
    private PersonRepository repo;

    public PersonServiceImpl(PersonRepository repository) {
        this.repo=repository;
    }

    @Override
    public PersonDto findOne(Integer integer) {
        Person person=repo.findOne(integer);
        return new PersonDto(person);
    }

    @Override
    public PersonDto save(PersonDto entity) {
        Person person=repo.save(entity.getEntity());

        return new PersonDto(person);
    }

    @Override
    public PersonDto update(PersonDto entity) {
        Person person=repo.update(entity.getEntity());
        return new PersonDto(person);
    }

    @Override
    public void delete(PersonDto entity) {
        repo.delete(entity.getEntity());
    }

    @Override
    public void deleteById(Integer integer) {
        repo.deleteById(integer);
    }


    @Override
    public List<PersonDto> findAll() {
        List<Person> people=repo.findAll();
        List<PersonDto> peopleList=null;
        for (Person person:people){
            if (peopleList==null){
                peopleList=new ArrayList<>();
            }
            PersonDto dto=new PersonDto(person);
            peopleList.add(dto);
        }
        return peopleList;
    }
}
