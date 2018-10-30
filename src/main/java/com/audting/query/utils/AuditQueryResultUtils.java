package com.audting.query.utils;

import org.hibernate.envers.RevisionType;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuditQueryResultUtils {

	public static <T> AuditQueryResult<T> getAuditQueryResultsWithRevInfo(Object[] item, Class<T> clazz) {
		if (item == null)
			return null;

		if (item.length < 3)
			return null;

		T entity = null;
		if (clazz.isInstance(item[0]))
			entity = clazz.cast(item[0]);
		CustomRevisionEntity revision = null;
		if (item[1] instanceof CustomRevisionEntity)
			revision = (CustomRevisionEntity) item[1];

		RevisionType revisionType = null;
		if (item[2] instanceof RevisionType)
			revisionType = (RevisionType) item[2];

		return new AuditQueryResult<T>(entity, revision, revisionType);
	}

}
