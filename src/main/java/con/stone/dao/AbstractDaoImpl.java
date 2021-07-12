package con.stone.dao;

import con.stone.entity.Person;
import con.stone.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDaoImpl<T> implements AbstractDao<T> {
    private Class<T> entityName;
    private Session session=null;
    private Transaction transaction=null;

    public AbstractDaoImpl(){
        this.entityName= (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T entity) {

        try{
            startOperation();
            session.save(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }


        return entity;
    }

    @Override
    public List<T> findAll() {
        List<Person> people=null;
        try{
            startOperation();
            TypedQuery<Person> query=session.createQuery("from  "+entityName.getName());
            people=query.getResultList();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return (List<T>) people;
    }
    private void startOperation(){
        session= HibernateUtils.getSessionFactory().openSession();
        transaction=session.beginTransaction();
    }
}
