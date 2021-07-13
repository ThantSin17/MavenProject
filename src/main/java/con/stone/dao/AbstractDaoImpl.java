package con.stone.dao;

import con.stone.entity.Person;
import con.stone.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDaoImpl<T,ID extends Comparable<ID>> implements AbstractDao<T,ID> {
    private Class<T> entityName;
    private Session session=null;
    private Transaction transaction=null;

    public AbstractDaoImpl(){
        this.entityName= (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findOne(ID id) {
        T entity=null;
        try{
            startOperation();
            entity= session.get(entityName,id);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }


        return entity;
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
    public T update(T entity) {
        try{
            startOperation();
            entity= (T) session.merge(entity);

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return  entity;
    }

    @Override
    public void delete(T entity) {
        try{
            startOperation();
            session.delete(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteById(ID id) {
        T entity=findOne(id);
        try{
            startOperation();
            session.delete(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
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
