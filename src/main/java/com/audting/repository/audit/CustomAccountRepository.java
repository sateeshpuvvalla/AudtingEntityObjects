package com.audting.repository.audit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;

import com.audting.model.Account;

@Repository
public class CustomAccountRepository implements ICustomerAccouctRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Number> getVersionNumbersByAccountId(Long accountId) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.getRevisions(Account.class, accountId);
	}

}
