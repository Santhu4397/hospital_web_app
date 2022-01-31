package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Address;
import com.hospital.dto.Branch;


public class AddressDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private BranchDao dao=new BranchDao();

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}

	public boolean save(int bid, Address add) {
		
		Branch branch=dao.getById(bid);
		if(branch != null ) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		add.setBranch(branch);
		entityManager.persist(add);
		entityTransaction.commit();
		return  true;
		}else {
			return false;
		}
	}
	public List<Address> getBybranchId(int id) {
		entityManager = getManager();
		Query query=entityManager.createQuery("select e from Address e where e.Branch.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
	public Address getUserById(int id) {
		entityManager = getManager();
		return entityManager.find(Address.class, id);
	}
	
	public List<Address> getAllUser() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Address c");
		return query.getResultList();
	}
	public void updateUser(Address add) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(add);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Address add=entityManager.find(Address.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}


}
