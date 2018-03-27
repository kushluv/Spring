package com.jspider.hibernat.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jspider.hibernat.DTO.MatrimonyDTO;
import com.jspides.hibernate.HibernateUtil.HibernateUtil;

public class matrimonyDAO {
	private SessionFactory factory = HibernateUtil.getSessionFactory();

	// Insert data Method
	public int SaveData(MatrimonyDTO dto) {
		Transaction tx = null;
		Session session = null;
		int id = 0;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			id = (Integer) session.save(dto);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}
	/*
	// Fetching Data Method
	public String getData(int PrimeryKey) {
		MatrimonyDTO dto = null;
		Session session = null;
		try {
			session = factory.openSession();
			dto = session.get(MatrimonyDTO.class, new Integer(PrimeryKey));
			//dto.getName();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		String st = "{" + dto.getpId() + "  " + dto.getName() + "  " + dto.getpAge() + "  " + dto.getQualification()
				+ "}";
		return st;
	}

	// Update Data Method
	public void updateData(int PrimeryKey, String name) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			MatrimonyDTO dto = session.load(MatrimonyDTO.class, PrimeryKey);
			dto.setName(name);
			session.update(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	// Delete Data Method
	public void deletData(int PrimeryKey) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			MatrimonyDTO dto = session.get(MatrimonyDTO.class, PrimeryKey);
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}*/

	// Fetch data more than one column using HQL query
	public List<MatrimonyDTO> fetchAllPerson() {
		String hql = "SELECT matrimony FROM MatrimonyDTO matrimony";
		Session session = null;
		List<MatrimonyDTO> matrimonyDTOs = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			matrimonyDTOs = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return matrimonyDTOs;
	}

	// Update person data using HQL Query
	public int updatePersonNameBYQlification(String PersonName, String qualification) {
		String hql = "UPDATE MatrimonyDTO matrimony SET matrimony.name=:nm WHERE matrimony.quali=:ql";
		Session session = null;
		int NoOfRowEffect = 0;
		MatrimonyDTO PersonName1 = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("nm", PersonName);
			query.setParameter("ql", qualification);
			NoOfRowEffect = query.executeUpdate();
			PersonName1 = (MatrimonyDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return NoOfRowEffect;
	}
	/*
	// Fetch data one column using HQL QUERY
	public MatrimonyDTO getAgeByname(String name) {
		String hql = "SELECT matrimony FROM MatrimonyDTO matrimony WHERE matrimony.name=:nm";
		Session session = null;
		int age = 0;
		MatrimonyDTO PersonName = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("nm", name);
			PersonName = (MatrimonyDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return PersonName;
	}

	// Fetch data Person id using HQL Query
	public MatrimonyDTO getPersonById(String name) {
		// String hql="SELECT matrimony FROM MatrimonyDTO matrimony WHERE
		// matrimony.name="+"'"+name+"'";
		String hql = "SELECT matrimony FROM MatrimonyDTO matrimony WHERE matrimony.name=" + "'" + name + "'";
		Session session = null;
		MatrimonyDTO PersonName = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			PersonName = (MatrimonyDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return PersonName;
	}

	public String getPersonName(int PrimeryKey) {
		String hql = "SELECT name FROM MatrimonyDTO WHERE pId='"+PrimeryKey+"'";
		Session session = null;
		Transaction tx = null;
		String PersonName = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			PersonName = (String) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return PersonName;
	}

	
	public Object[] getAgeandnameById(int primeryKey) {
		String hql = "SELECT matrimony.name,matrimony.pAge FROM MatrimonyDTO matrimony WHERE matrimony.pId=:nm";
		Session session = null;
		int age = 0;
		Object[] PersonName = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("nm",primeryKey);
			PersonName = (Object[])query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return PersonName;
	}*/
}
