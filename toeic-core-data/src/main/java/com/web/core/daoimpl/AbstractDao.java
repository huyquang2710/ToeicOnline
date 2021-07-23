package com.web.core.daoimpl;

import com.web.core.common.constant.CoreConstant;
import com.web.core.common.utils.HibernateUtil;
import com.web.core.dao.GenericDao;
import org.hibernate.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

// muon T thay cho cac Enttyti. truyen ID vao
public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    //Get ten Class
    private Class<T> persistenceClass;

    //Cap gia tri cho persistenceClass
    public AbstractDao() {
        //get ten
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //vi persistenceClass o dang Class. nhung trong talbe la String
    // Ham chuyen
    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }


    @Override
    public List<T> findAll() {
        //get Session tu HibernateUtil
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<T> list = new ArrayList<>();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }  finally {
            session.close();
        }
        return list;
    }

    @Override
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T)object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session.get(persistenceClass, id);
            if(result == null) {
                throw  new ObjectNotFoundException("NOT FOUND" + id, null);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Object[] findyProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;

        try {
            StringBuilder hql1 = new StringBuilder("from ");
            hql1    .append(getPersistenceClassName());
            if (property != null && value != null) {
                hql1.append(" where ").append(property).append("= :value");
            }
            if (sortDirection != null && sortExpression != null) {
                hql1.append(" order by ").append(sortDirection);
                hql1.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query1 = session.createQuery(hql1.toString());

            if(value != null) {
                query1.setParameter("value", value);
            }

            list = query1.list();

            //Size tong so item cua list tra ve
            StringBuilder hql2 = new StringBuilder("select count(*) from ");
            hql2.append(getPersistenceClassName());

            if(property != null && value != null) {
                hql2.append(" where ").append(property).append("= :value");
            }
            Query query2 = session.createQuery(hql2.toString());
            if(value != null) {
                query2.setParameter("value", value);
            }

            //tong so item cua list tra ve
            totalItem = query2.list().get(0);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItem, list};
    }

    @Override
    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for(ID item: ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw  e;
        } finally {
            session.close();
        }
        return count;
    }
}
