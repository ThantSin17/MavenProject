package con.stone.controller;

import con.stone.dto.PersonDto;
import con.stone.entity.Person;
import con.stone.service.PersonService;
import con.stone.view.AbstractView;
import con.stone.view.PersonView;

import java.util.ArrayList;
import java.util.List;

public class PersonControllerImpl extends AbstractControllerImpl<Person, PersonView> implements PersonController<Person> {
    PersonService service;

    public PersonControllerImpl(PersonService service) {
        this.service=service;
    }

    @Override
    public Person findById(int id) {
        PersonDto dto=service.findOne(id);
        return dto.getEntity();
    }

    @Override
    public List<Person> findAll() {
       List<PersonDto> dtoList=service.findAll();
       List<Person> people=new ArrayList<>();
       for (PersonDto dto:dtoList){
           people.add(dto.getEntity());
       }
        return people;
    }

    @Override
    public Person save(Person model) {
        return service.save(new PersonDto(model)).getEntity();
    }

    @Override
    public Person update(Person model) {
        return service.update(new PersonDto(model)).getEntity();
    }

    @Override
    public void delete(Person model) {
        service.delete(new PersonDto(model));
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }



    @Override
    public Person getModel() {
        return super.getModel();
    }

    @Override
    public void setModel(Person person) {
        super.setModel(person);
    }

    @Override
    public PersonView getView() {
        return super.getView();
    }

    @Override
    public void setView(PersonView view) {
        super.setView(view);
    }

    @Override
    public void printDetails(Person person) {
        super.printDetails(person);
    }

    @Override
    public void printDetails(List<Person> people) {
        super.printDetails(people);
    }
}
