package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.EmployerInfo;

public class EmployerDAOImpl extends BaseDAO implements IEmployerDAO {

	public List<EmployerInfo> getAllEmployerEmails(Long employerId) {
		Criteria criteria = getSession().createCriteria(EmployerInfo.class);
		if(null != employerId){
			criteria.add(Restrictions.like("joinedEmailEmployerId.employerId", employerId.toString()));
		}
		List<EmployerInfo> employerEmailList = criteria.list();
		return employerEmailList;
	}
}
