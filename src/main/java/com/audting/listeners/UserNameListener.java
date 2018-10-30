package com.audting.listeners;

import java.util.Date;

import org.hibernate.envers.RevisionListener;

import com.audting.query.utils.CustomRevisionEntity;

public class UserNameListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		if (revisionEntity instanceof CustomRevisionEntity) {
			CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) revisionEntity;
			customRevisionEntity.setUserName("Sateesh Puvvalla");
			customRevisionEntity.setLastModifiedDate(new Date());
		}
	}

}
