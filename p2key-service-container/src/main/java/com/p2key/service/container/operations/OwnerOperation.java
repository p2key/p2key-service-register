package com.p2key.service.container.operations;

import java.util.List;

import org.hibernate.Session;

import com.p2key.service.container.model.Owner;
import com.p2key.service.container.util.HibernateUtil;

public class OwnerOperation {

	public static List<Owner> getAllOwners() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Owner> owners = s.createQuery("from Owner").list();
			s.getTransaction().commit();
			return owners;
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return null;
	}

	public static Owner getOwner(long ownerId) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Owner> owners = s.createQuery("from Owner where id=" + ownerId).list();
			s.getTransaction().commit();
			return owners.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return null;
	}
}
