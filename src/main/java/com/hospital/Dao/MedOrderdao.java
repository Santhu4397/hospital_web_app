package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Branch;
import com.hospital.dto.Encounter;
import com.hospital.dto.MedOrder;
import com.hospital.dto.User;

public class MedOrderdao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private EncounterDao dao=new EncounterDao();

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}
		
	public void save(int eid,MedOrder order) {
		Encounter encounter=dao.getById(eid);
		
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		order.setEncounter(encounter);
		entityManager.persist(order);
		entityTransaction.commit();
		
	}
	public MedOrder getById(int id) {
		entityManager = getManager();
		return entityManager.find(MedOrder.class, id);
	}
	public List<MedOrder> getByencounterid(int id) {
		entityManager = getManager();
		Query query=entityManager.createQuery("select e from MedOrder e where e.encounter.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
	public List<MedOrder> getAll() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from MedOrder c");
		return query.getResultList();
	}
	public void update(MedOrder branch) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		MedOrder add=entityManager.find(MedOrder.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}


}
