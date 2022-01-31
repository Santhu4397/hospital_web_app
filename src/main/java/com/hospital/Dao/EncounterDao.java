package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Branch;
import com.hospital.dto.Encounter;
import com.hospital.dto.Hospital;
import com.hospital.dto.Person;

public class EncounterDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private PersonDao pdao=new PersonDao();
	private BranchDao bdao=new BranchDao();

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}
		
	public boolean save(int pid,int bid,Encounter encounter) {
		Person person=pdao.getById(pid);
		Branch branch=bdao.getById(bid);
		System.out.println(pid);
		System.out.println(person);
		System.out.println(bid);
		System.out.println(branch);
		if(person != null && branch != null) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		encounter.setBranch(branch);
		encounter.setPreson(person);
		entityManager.persist(encounter);
		entityTransaction.commit();
		return true;
		}else {
			return false;
		}
	}
	
	public List<Encounter> getBypersonId(int id) {
		entityManager = getManager();
		Query query=entityManager.createQuery("select e from Encounter e where e.preson.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
	public Encounter getById(int id) {
		entityManager = getManager();
		return entityManager.find(Encounter.class, id);
	}
	public List<Encounter> getAll() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from Encounter c");
		return query.getResultList();
	}
	public void update(Encounter branch) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		
		
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		
	}
	public void delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		Encounter add=entityManager.find(Encounter.class, id);
		if(add!=null) {
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
	}


}
