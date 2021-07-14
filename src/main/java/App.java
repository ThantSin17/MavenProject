import con.stone.controller.LaptopController;
import con.stone.controller.LaptopControllerImpl;
import con.stone.controller.PersonController;
import con.stone.controller.PersonControllerImpl;
import con.stone.dao.LaptopDaoImpl;
import con.stone.dao.PersonDaoImpl;
import con.stone.entity.FullName;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import con.stone.repository.LaptopRepository;
import con.stone.repository.PersonRepository;
import con.stone.service.LaptopService;
import con.stone.service.LaptopServiceImpl;
import con.stone.service.PersonService;
import con.stone.service.PersonServiceImpl;

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
        PersonController<Person> controller=new PersonControllerImpl(personService);

        List<Person> people=controller.findAll();
        controller.printDetails(people);

        LaptopRepository laptopRepository=new LaptopDaoImpl();
        LaptopService service=new LaptopServiceImpl(laptopRepository);
        LaptopController<Laptop> laptopController=new LaptopControllerImpl(service);

        List<Laptop> laptopList=laptopController.findAll();
        laptopController.printDetails(laptopList);

        //personRepo.save(person);
        //personRepo.save(person1);


    }
}
