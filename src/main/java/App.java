import con.stone.entity.FullName;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import con.stone.mysql.MySqlDB;
import con.stone.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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



        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        session.save(person);
        session.save(person1);

        transaction.commit();
        session.close();




    }
}
