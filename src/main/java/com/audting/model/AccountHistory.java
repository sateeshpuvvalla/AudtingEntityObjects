package com.audting.model;

import java.io.Serializable;

import org.hibernate.envers.RevisionType;

import com.audting.query.utils.CustomRevisionEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AccountHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4058366174582719628L;
	private Account account;
	private CustomRevisionEntity revision;
	private RevisionType revisionType;

}
