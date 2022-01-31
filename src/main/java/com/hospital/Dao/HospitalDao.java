package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Branch;
import com.hospital.dto.Hospital;

public class HospitalDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		
		return entityManagerFactory.createEntityManager();
	}

	public void save(Hospital hospital ) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	public Hospital getById(int id) {
		entityManager = getManager();
		return entityManager.find(Hospital.class, id);
	}
	public List<Hospital> getAll() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Hospital c");
		return query.getResultList();
	}
	public void update(Hospital branch) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Hospital add=entityManager.find(Hospital.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}


}
