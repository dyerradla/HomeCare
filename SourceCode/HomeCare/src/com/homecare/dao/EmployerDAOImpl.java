package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerInfo;

public class EmployerDAOImpl extends BaseDAO implements IEmployerDAO {

	public List<EmployerEmailInfo> getAllEmployerEmails(Long employerId) {
		Criteria criteria = getSession().createCriteria(EmployerEmailInfo.class);
		if(null != employerId){
			criteria.add(Restrictions.like("joinedEmailEmployerId.employerId", employerId.toString()));
		}
		List<EmployerEmailInfo> employerEmailList = criteria.list();
		if(null != employerEmailList && !employerEmailList.isEmpty()){
			for(EmployerEmailInfo employerInfo : employerEmailList){
				employerInfo.setEmployerInfo(getEmployerInfo(employerId));
			}
		}
		return employerEmailList;
	}
	
	
	public EmployerInfo getEmployerInfo(Long employerId) {
		EmployerInfo returnEmployer = null;
		Criteria criteria = getSession().createCriteria(EmployerInfo.class);
		if(null != employerId){
			criteria.add(Restrictions.like("employerId", employerId));
		}
		List<EmployerInfo> employers = criteria.list();
		if(null != employers && !employers.isEmpty()){
			returnEmployer = employers.get(0);
		}
		return returnEmployer;
	}
	
	public void saveEmployer(EmployerInfo employerInfo){
		saveOrUpdateObject(employerInfo);
	}
	
}
