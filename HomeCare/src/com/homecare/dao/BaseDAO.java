package com.homecare.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport {

	// Saves or Updates the List of Objects
	public void saveOrUpdateList(List updateList) {
		if (null != updateList && !updateList.isEmpty()) {
			for (Object obj : updateList) {
				saveOrUpdateObject(obj);
			}
		}
	}

	/**
	 * It adds a new Object
	 * 
	 * @param obj
	 */
	public void saveObject(Object obj) {
		getHibernateTemplate().save(obj);
	}

	/**
	 * It checks whether the Object exists,If present update the object
	 * otherwise add a New Row.
	 * 
	 * @param obj
	 */
	// Saves or Update the Current Object
	public void saveOrUpdateObject(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	// Saves or Update the Current Object
	public void mergeObjects(Object obj) {
		getHibernateTemplate().merge(obj);
	}

	public Object loadObjectByPrimaryKey(Class refClass,
			Serializable serializableKey) {
		Object singleResult =

		null;
		if (null == serializableKey || null == refClass) {
			singleResult =

			null;
		}

		else {
			if (serializableKey instanceof Boolean) {
				singleResult = getSession().load(refClass,
						(Boolean) serializableKey);

			}

			else if (serializableKey instanceof String) {
				singleResult = getSession().load(refClass,
						(String) serializableKey);

			}

			else if (serializableKey instanceof Integer) {
				singleResult = getSession().load(refClass,
						(Integer) serializableKey);

			}

			else if (serializableKey instanceof Long) {
				singleResult = getSession().load(refClass,
						(Long) serializableKey);

			}

			else if (serializableKey instanceof Float) {
				singleResult = getSession().load(refClass,
						(Float) serializableKey);

			}

			else if (serializableKey instanceof Double) {
				singleResult = getSession().load(refClass,
						(Double) serializableKey);

			}

			else if (serializableKey instanceof BigDecimal) {
				singleResult = getSession().load(refClass,
						(BigDecimal) serializableKey);

			}

			else if (serializableKey instanceof Byte) {
				singleResult = getSession().load(refClass,
						(Byte) serializableKey);

			}

			else if (serializableKey instanceof Calendar) {
				singleResult = getSession().load(refClass,
						(Calendar) serializableKey);

			}

			else if (serializableKey instanceof Character) {
				singleResult = getSession().load(refClass,
						(Character) serializableKey);

			}

			else if (serializableKey instanceof Timestamp) {
				singleResult = getSession().load(refClass,
						(Timestamp) serializableKey);

			}

			else if (serializableKey instanceof Date) {
				singleResult = getSession().load(refClass,
						(Date) serializableKey);

			}

			else if (serializableKey instanceof Short) {
				singleResult = getSession().load(refClass,
						(Short) serializableKey);

			}

		}

		Hibernate.initialize(singleResult);

		return singleResult;
	}

	public Object read(Class refClass, Serializable serializableKey) {
		return loadObjectByPrimaryKey(refClass, serializableKey);
	}

	public void deleteObject(Object obj) {
		if (obj != null)
			getSession().delete(obj);

	}

	public void initializeObject(Object obj) {
		if (!Hibernate.isInitialized(obj))
			getHibernateTemplate().initialize(obj);

	}
}
