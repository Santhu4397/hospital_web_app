package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Branch;
import com.hospital.dto.Hospital;
import com.hospital.dto.User;

public class UserDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private BranchDao dao=new BranchDao();

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}
		
	public void save(int bid,User user) {
		Branch branch=dao.getById(bid);
		
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		user.setBranch(branch);
		entityManager.persist(user);
		entityTransaction.commit();
		
	}
	public User validate(String email,String password) {
		entityManager=getManager();
		Query query=entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users=query.getResultList();
		if(users != null && users.size()>0) {
			 return users.get(0);
			
		}else {
			return null;
		}
		
		
	}
	public Branch getById(int id) {
		entityManager = getManager();
		return entityManager.find(Branch.class, id);
	}
	public List<Branch> getAll() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Branch c");
		return query.getResultList();
	}
	public void update(Branch branch) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Branch add=entityManager.find(Branch.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}


}
