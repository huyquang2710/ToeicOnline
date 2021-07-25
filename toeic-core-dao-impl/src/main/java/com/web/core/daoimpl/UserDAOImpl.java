package com.web.core.daoimpl;

import com.web.core.common.utils.HibernateUtil;
import com.web.core.dao.UserDAO;
import com.web.core.persistence.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl extends AbstractDao<Integer, UserEntity> implements UserDAO {
    @Override
    public UserEntity isUserExist(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity = new UserEntity();

        try {
            StringBuilder hql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return entity;
    }

    @Override
    public UserEntity findRoleByUser(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity = new UserEntity();

        try {
            StringBuilder hql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return entity;
    }
}
