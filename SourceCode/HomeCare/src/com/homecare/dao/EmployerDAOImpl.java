package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerSendEmail;

public class EmployerDAOImpl extends BaseDAO implements IEmployerDAO {

	public List<EmployerEmailInfo> getAllEmployerEmails(Long employerId) {
		Criteria criteria = getSession().createCriteria(EmployerEmailInfo.class);
		if(null != employerId){
			criteria.add(Restrictions.like("joinedEmailEmployerId.employerId", employerId.toString()));
		}
		List<EmployerEmailInfo> employerEmailList = criteria.list();
		if(null != employerEmailList && !employerEmailList.isEmpty()){
			for(EmployerEmailInfo employerInfo : employerEmailList){
				employerInfo.setEmployerSendEmail(getEmployerSendEmail(employerId));
			}
		}
		return employerEmailList;
	}
	
	
	public EmployerSendEmail getEmployerSendEmail(Long employerId) {
		Criteria criteria = getSession().createCriteria(EmployerSendEmail.class);
		if(null != employerId){
			criteria.add(Restrictions.like("employerId", employerId));
		}
		List<EmployerSendEmail> employerSendEmailList = criteria.list();
		EmployerSendEmail returnEmployerSendEmail = null;
		if(null != employerSendEmailList && !employerSendEmailList.isEmpty()){
			returnEmployerSendEmail = employerSendEmailList.get(0);
		}
		return returnEmployerSendEmail;
	}
}
