package com.audting.repository.audit;

import java.util.List;

public interface ICustomerAccouctRepository {

	public List<Number> getVersionNumbersByAccountId(Long accountId);

}
