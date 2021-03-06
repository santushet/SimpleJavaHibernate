package com.santosh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.santosh.model.User;
import com.santosh.util.HibernateUtil;

public class UserDao {

	public void addUser(User user) {
		Transaction tr = null;
		Session session = HibernateUtil.createSessionFactory().openSession();
		try {
			tr = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			if (tr != null)
				tr.rollback();
			ex.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		
	}
	
	public void updateUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
	
	public List<User> getAllUsers() {
		Transaction trns = null;
		List<User> users=new ArrayList<>();
        Session session = HibernateUtil.createSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users=session.createQuery("from users").list();
        }
        catch(RuntimeException e){
        	if(trns!=null)
        		trns.rollback();
        	e.printStackTrace();
        }
        finally{
        	session.flush();
        	session.close();
        }
        return users;
	}
	
	 public User getUserById(int userid) {
	        User user = null;
	        Transaction trns = null;
	        Session session = HibernateUtil.createSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from User where id = :id";
	            Query query = session.createQuery(queryString);
	            query.setInteger("id", userid);
	            user = (User) query.uniqueResult();
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return user;
	    }
	 
	 public void deleteUser(int userid) {
	        Transaction trns = null;
	        Session session = HibernateUtil.createSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            User user = (User) session.load(User.class, new Integer(userid));
	            session.delete(user);
	            session.getTransaction().commit();
	        } catch (RuntimeException e) {
	            if (trns != null) {
	                trns.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	    }
}
