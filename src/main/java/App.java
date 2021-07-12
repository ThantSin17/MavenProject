import con.stone.dao.LaptopDaoImpl;
import con.stone.dao.PersonDaoImpl;
import con.stone.entity.FullName;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import con.stone.repository.LaptopRepository;
import con.stone.repository.PersonRepository;
import con.stone.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Laptop laptop=new Laptop();
        laptop.setBrand("Dell");
        laptop.setDescription("it for sell");


        Person person=new Person();
        person.setFullName(new FullName("mg ","mg"));
        person.setAge(24);
        person.setLaptop(laptop);

        Person person1=new Person();
        person1.setFullName(new FullName("hla ","hla"));
        person1.setAge(24);
        person1.setLaptop(laptop);


        PersonRepository personRepo=new PersonDaoImpl();
       
        //personRepo.save(person);
        //personRepo.save(person1);

        List<Person> people=personRepo.findAll();
        for (Person p:people){
            System.out.println(p.getFullName().getFirstName());
        }

        LaptopRepository laptopRepo=new LaptopDaoImpl();
        List<Laptop> laptops=laptopRepo.findAll();
        for (Laptop laptop1:laptops){
            System.out.println(laptop1.getBrand());
        }

    }
}
