package con.stone.utils;

import con.stone.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static SessionFactory buildSessionFactory(){
        Configuration config=new Configuration().configure().addAnnotatedClass(Person.class);
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        return config.buildSessionFactory(reg);
    }
    public static SessionFactory getSessionFactory(){
        return buildSessionFactory();
    }
}
