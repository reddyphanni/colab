package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.User;
@Repository
public class userDAOImpl implements userDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*public void add(User user) {
		Session session=sessionFactory.getCurrentSession();
		Transaction t=session.beginTransaction();
		session.saveOrUpdate(user);
		t.commit();
		}
*/
  public void delete( int id){
	  Session session= sessionFactory.getCurrentSession();
	  User deleteu=new User();
	  deleteu.setId(id);
	  Transaction t=session.beginTransaction();
	  session.delete(deleteu);
		t.commit();
	 
  }
  public User getuser(int id){
	  Session session= sessionFactory.getCurrentSession();
	  String hql ="from"+ "user"+ "where id ="+ id;
	  Query query=session.createQuery(hql);
	  List<User> user = (List<User>)query.list();
	  if(user!=null&&!user.isEmpty()){
	  return user.get(0);
	  }
	  
	  
	  return null;
	  
	  
	  
	  
	  
  }
  public List<User> userlist(){
	  List<User> listuser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	  return listuser;
	  
	  
	  
	  
	  
	  
  }
  public void de( int id){
	  Session session= sessionFactory.getCurrentSession();
	  User deleteu=new User();
	  deleteu.setId(id);
	  Transaction t=session.beginTransaction();
	  session.delete(deleteu);
		t.commit();
	  
	  
  }


