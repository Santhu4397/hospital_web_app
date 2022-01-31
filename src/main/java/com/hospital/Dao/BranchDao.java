package com.hospital.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hospital.dto.Address;
import com.hospital.dto.Branch;
import com.hospital.dto.Encounter;
import com.hospital.dto.Hospital;

public class BranchDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private HospitalDao dao=new HospitalDao();;

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}
		
	public boolean save(int hid,Branch branch,Address address) {
		Hospital hospital=dao.getById(hid);
		if(hospital != null) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		branch.setHospital(hospital);
		branch.setAddress(address);
		entityManager.persist(branch);
		entityTransaction.commit();
		return true;
		}else {
			return false;
		}
	}

	public Branch getById(int id) {
		entityManager = getManager();
		return entityManager.find(Branch.class, id);
	}
	public List<Branch> getByhospitalId(int id) {
		entityManager = getManager();
		Query query=entityManager.createQuery("select e from Branch e where e.hospital.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
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
