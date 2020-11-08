package com.p2key.service.container.operations;

import java.util.List;

import org.hibernate.Session;

import com.p2key.service.container.model.Service;
import com.p2key.service.container.util.HibernateUtil;

public class ServiceOperation {
	public static List<Service> getAllServices() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Service> services = s.createQuery("from Service").list();
			s.getTransaction().commit();
			return services;
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return null;
	}

	public static List<Service> getAllActiveServices() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Service> services = s.createQuery("from Service where isActive=true").list();
			s.getTransaction().commit();
			return services;
		} catch (Exception e) {
			s.getTransaction().rollback();
		}
		return null;
	}

	public static List<Service> getAllDeactiveServices() {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Service> services = s.createQuery("from Service where isActive=false").list();
			s.getTransaction().commit();
			return services;
		} catch (Exception e) {
			s.getTransaction().rollback();
		}
		return null;
	}

	public static Service getService(String serviceName) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Service> services = s.createQuery("from Service where name='" + serviceName + "'").list();
			s.getTransaction().commit();
			return services.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			return null;
		}
	}

	public static boolean insertService(Service model) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.save(model);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			return false;
		}
		return true;
	}
	

	public static boolean updateService(Service model) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.update(model);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			return false;
		}
		return true;
	}
	
	public static boolean deleteService(Service model) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			s.delete(model);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			return false;
		}
		return true;
	}

}
