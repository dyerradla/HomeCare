package com.homecare.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport{
	
	// Saves or Updates the List of Objects
	public void saveOrUpdateList(List updateList){
		if(null != updateList && !updateList.isEmpty()){
			for(Object obj : updateList){
				saveOrUpdateObject(obj);
			}
		}
	}

	/**
	 * It adds a new Object
	 * @param obj
	 */
	public void saveObject(Object obj){
		getHibernateTemplate().save(obj);
	}
	
	/**
	 * It checks whether the Object exists,If present update the object otherwise add a New Row.
	 * @param obj
	 */
	// Saves or Update the Current Object
	public void saveOrUpdateObject(Object obj){
		getHibernateTemplate().saveOrUpdate(obj);
	}
	

	// Saves or Update the Current Object
	public void mergeObjects(Object obj){
		getHibernateTemplate().merge(obj);
	}
}
