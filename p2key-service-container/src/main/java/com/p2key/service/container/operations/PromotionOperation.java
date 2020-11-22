package com.p2key.service.container.operations;

import java.util.List;

import org.hibernate.Session;

import com.p2key.service.container.model.Promotion;
import com.p2key.service.container.util.HibernateUtil;

public class PromotionOperation {
	public static Promotion getPromotion(String operation) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Promotion> promotions = s.createQuery("from Promotion where operation='" + operation+"'").list();
			s.getTransaction().commit();
			return promotions.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		}
		return null;
	}
}
