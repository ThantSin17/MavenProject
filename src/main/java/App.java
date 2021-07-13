import con.stone.dao.LaptopDaoImpl;
import con.stone.dao.PersonDaoImpl;
import con.stone.dto.LaptopDto;
import con.stone.dto.PersonDto;
import con.stone.entity.FullName;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import con.stone.repository.LaptopRepository;
import con.stone.repository.PersonRepository;
import con.stone.service.LaptopService;
import con.stone.service.LaptopServiceImpl;
import con.stone.service.PersonService;
import con.stone.service.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setDescription("it for sell");


        Person person = new Person();
        person.setId(2);
        person.setFullName(new FullName("ko ", "ko"));
        person.setAge(21);
        person.setLaptop(laptop);

        Person person1 = new Person();
        person1.setFullName(new FullName("hla ", "hla"));
        person1.setAge(24);
        person1.setLaptop(laptop);


        PersonRepository personRepo = new PersonDaoImpl();
        PersonService personService = new PersonServiceImpl(personRepo);

        //personRepo.save(person);
        //personRepo.save(person1);

        List<PersonDto> people = personService.findAll();
        List<Person> peopleList = new ArrayList<>();
        for (PersonDto p : people) {
            peopleList.add(p.getEntity());
        }

        for (Person p : peopleList) {
            System.out.println(p.getFullName().getFirstName());
        }
        LaptopRepository laptopRepo = new LaptopDaoImpl();
        LaptopService laptopService = new LaptopServiceImpl(laptopRepo);
        List<LaptopDto> laptopDtoList = laptopService.findAll();
        List<Laptop> laptopList = new ArrayList<>();
        for (LaptopDto dto : laptopDtoList) {
            laptopList.add(dto.getEntity());
        }
        for (Laptop laptop1 : laptopList) {
            System.out.println(laptop1.getBrand());
        }


       // PersonDto p = personService.update(new PersonDto(person));
        //System.out.println(p.getFirstName());

        personService.deleteById(11);

        LaptopDto l = laptopService.findOne(5);
        System.out.println(l.getBrand());




    }
}
