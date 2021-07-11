import con.stone.entity.Person;
import con.stone.mysql.MySqlDB;
import con.stone.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    public static void main(String[] args) {
        MySqlDB db=new MySqlDB();
        db.init();
        Person person=new Person();
        person.setName("Mg Mg");
        person.setAge(24);



        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        session.save(person);
        transaction.commit();
        session.close();




    }
}
