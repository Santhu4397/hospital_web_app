package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Branch;
import com.hospital.dto.Encounter;
import com.hospital.dto.Item;
import com.hospital.dto.MedOrder;

public class ItemDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private MedOrderdao dao=new MedOrderdao();

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}
		
	public void save(int eid,Item it) {
		MedOrder medOrder=dao.getById(eid);
		
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		it.setMedOrder(medOrder);
		entityManager.persist(it);
		entityTransaction.commit();
		
	}
	public Item getById(int id) {
		entityManager = getManager();
		return entityManager.find(Item.class, id);
	}
	public List<Item> getByorderId(int id) {
		entityManager = getManager();
		Query query=entityManager.createQuery("select e from Item e where e.MedOrder.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
	public List<Item> getAll() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Item c");
		return query.getResultList();
	}
	public void update(Item branch) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Item add=entityManager.find(Item.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}

}
