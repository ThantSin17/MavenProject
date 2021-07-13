package con.stone.service;

import con.stone.dao.PersonDaoImpl;
import con.stone.dto.PersonDto;
import con.stone.entity.Person;
import con.stone.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService{
    private PersonRepository repo=null;

    public PersonServiceImpl(PersonRepository repository) {
        this.repo=repository;
    }

    @Override
    public PersonDto findOne(Integer integer) {
        Person person=repo.findOne(integer);
        PersonDto dto=new PersonDto(person);
        return dto;
    }

    @Override
    public PersonDto save(PersonDto entity) {
        Person person=repo.save(entity.getEntity());

        return new PersonDto(person);
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
