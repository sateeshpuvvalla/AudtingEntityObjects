package com.audting.query.utils;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.audting.listeners.UserNameListener;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RevisionEntity(UserNameListener.class)
@Table(name = "revinfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomRevisionEntity implements Serializable {

	private static final long serialVersionUID = -4628717324196614162L;

	@Id
	@RevisionNumber
	@GeneratedValue
	@Column(name = "rev")
	private int revisionNumber;

	@RevisionTimestamp
	@Column(name = "revtstmp")
	private long revisionTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;

	@Column(name = "user_name")
	private String userName;

}
