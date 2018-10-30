package com.audting.query.utils;

import org.hibernate.envers.RevisionType;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class AuditQueryResult<T> {

	private T entity;
	private CustomRevisionEntity revision;
	private RevisionType type;
}
