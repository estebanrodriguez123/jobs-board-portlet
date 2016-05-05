/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.jobsboard.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rivetlogic.jobsboard.model.Job;
import com.rivetlogic.jobsboard.model.JobModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Job service. Represents a row in the &quot;rivetlogic_jobsboard_Job&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rivetlogic.jobsboard.model.JobModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobImpl}.
 * </p>
 *
 * @author joseross
 * @see JobImpl
 * @see com.rivetlogic.jobsboard.model.Job
 * @see com.rivetlogic.jobsboard.model.JobModel
 * @generated
 */
public class JobModelImpl extends BaseModelImpl<Job> implements JobModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job model instance should use the {@link com.rivetlogic.jobsboard.model.Job} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_jobsboard_Job";
	public static final Object[][] TABLE_COLUMNS = {
			{ "jobId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "active_", Types.BOOLEAN },
			{ "category", Types.BIGINT },
			{ "location", Types.BIGINT },
			{ "type_", Types.BIGINT },
			{ "description", Types.CLOB },
			{ "salary", Types.DOUBLE },
			{ "bookmarks", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table rivetlogic_jobsboard_Job (jobId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,active_ BOOLEAN,category LONG,location LONG,type_ LONG,description TEXT null,salary DOUBLE,bookmarks VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_jobsboard_Job";
	public static final String ORDER_BY_JPQL = " ORDER BY job.jobId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_jobsboard_Job.jobId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.jobsboard.model.Job"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.jobsboard.model.Job"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.jobsboard.model.Job"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long BOOKMARKS_COLUMN_BITMASK = 2L;
	public static long CATEGORY_COLUMN_BITMASK = 4L;
	public static long COMPANYID_COLUMN_BITMASK = 8L;
	public static long DESCRIPTION_COLUMN_BITMASK = 16L;
	public static long GROUPID_COLUMN_BITMASK = 32L;
	public static long LOCATION_COLUMN_BITMASK = 64L;
	public static long NAME_COLUMN_BITMASK = 128L;
	public static long TYPE_COLUMN_BITMASK = 256L;
	public static long JOBID_COLUMN_BITMASK = 512L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.jobsboard.model.Job"));

	public JobModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Job.class;
	}

	@Override
	public String getModelClassName() {
		return Job.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("active", getActive());
		attributes.put("category", getCategory());
		attributes.put("location", getLocation());
		attributes.put("type", getType());
		attributes.put("description", getDescription());
		attributes.put("salary", getSalary());
		attributes.put("bookmarks", getBookmarks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long category = (Long)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long location = (Long)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double salary = (Double)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String bookmarks = (String)attributes.get("bookmarks");

		if (bookmarks != null) {
			setBookmarks(bookmarks);
		}
	}

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@Override
	public long getCategory() {
		return _category;
	}

	@Override
	public void setCategory(long category) {
		_columnBitmask |= CATEGORY_COLUMN_BITMASK;

		if (!_setOriginalCategory) {
			_setOriginalCategory = true;

			_originalCategory = _category;
		}

		_category = category;
	}

	public long getOriginalCategory() {
		return _originalCategory;
	}

	@Override
	public long getLocation() {
		return _location;
	}

	@Override
	public void setLocation(long location) {
		_columnBitmask |= LOCATION_COLUMN_BITMASK;

		if (!_setOriginalLocation) {
			_setOriginalLocation = true;

			_originalLocation = _location;
		}

		_location = location;
	}

	public long getOriginalLocation() {
		return _originalLocation;
	}

	@Override
	public long getType() {
		return _type;
	}

	@Override
	public void setType(long type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public long getOriginalType() {
		return _originalType;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_columnBitmask |= DESCRIPTION_COLUMN_BITMASK;

		if (_originalDescription == null) {
			_originalDescription = _description;
		}

		_description = description;
	}

	public String getOriginalDescription() {
		return GetterUtil.getString(_originalDescription);
	}

	@Override
	public double getSalary() {
		return _salary;
	}

	@Override
	public void setSalary(double salary) {
		_salary = salary;
	}

	@Override
	public String getBookmarks() {
		if (_bookmarks == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookmarks;
		}
	}

	@Override
	public void setBookmarks(String bookmarks) {
		_columnBitmask |= BOOKMARKS_COLUMN_BITMASK;

		if (_originalBookmarks == null) {
			_originalBookmarks = _bookmarks;
		}

		_bookmarks = bookmarks;
	}

	public String getOriginalBookmarks() {
		return GetterUtil.getString(_originalBookmarks);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Job.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Job toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Job)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JobImpl jobImpl = new JobImpl();

		jobImpl.setJobId(getJobId());
		jobImpl.setGroupId(getGroupId());
		jobImpl.setCompanyId(getCompanyId());
		jobImpl.setUserId(getUserId());
		jobImpl.setUserName(getUserName());
		jobImpl.setCreateDate(getCreateDate());
		jobImpl.setModifiedDate(getModifiedDate());
		jobImpl.setName(getName());
		jobImpl.setActive(getActive());
		jobImpl.setCategory(getCategory());
		jobImpl.setLocation(getLocation());
		jobImpl.setType(getType());
		jobImpl.setDescription(getDescription());
		jobImpl.setSalary(getSalary());
		jobImpl.setBookmarks(getBookmarks());

		jobImpl.resetOriginalValues();

		return jobImpl;
	}

	@Override
	public int compareTo(Job job) {
		long primaryKey = job.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Job)) {
			return false;
		}

		Job job = (Job)obj;

		long primaryKey = job.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		JobModelImpl jobModelImpl = this;

		jobModelImpl._originalGroupId = jobModelImpl._groupId;

		jobModelImpl._setOriginalGroupId = false;

		jobModelImpl._originalCompanyId = jobModelImpl._companyId;

		jobModelImpl._setOriginalCompanyId = false;

		jobModelImpl._originalName = jobModelImpl._name;

		jobModelImpl._originalActive = jobModelImpl._active;

		jobModelImpl._setOriginalActive = false;

		jobModelImpl._originalCategory = jobModelImpl._category;

		jobModelImpl._setOriginalCategory = false;

		jobModelImpl._originalLocation = jobModelImpl._location;

		jobModelImpl._setOriginalLocation = false;

		jobModelImpl._originalType = jobModelImpl._type;

		jobModelImpl._setOriginalType = false;

		jobModelImpl._originalDescription = jobModelImpl._description;

		jobModelImpl._originalBookmarks = jobModelImpl._bookmarks;

		jobModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Job> toCacheModel() {
		JobCacheModel jobCacheModel = new JobCacheModel();

		jobCacheModel.jobId = getJobId();

		jobCacheModel.groupId = getGroupId();

		jobCacheModel.companyId = getCompanyId();

		jobCacheModel.userId = getUserId();

		jobCacheModel.userName = getUserName();

		String userName = jobCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			jobCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jobCacheModel.createDate = createDate.getTime();
		}
		else {
			jobCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jobCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jobCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jobCacheModel.name = getName();

		String name = jobCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			jobCacheModel.name = null;
		}

		jobCacheModel.active = getActive();

		jobCacheModel.category = getCategory();

		jobCacheModel.location = getLocation();

		jobCacheModel.type = getType();

		jobCacheModel.description = getDescription();

		String description = jobCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			jobCacheModel.description = null;
		}

		jobCacheModel.salary = getSalary();

		jobCacheModel.bookmarks = getBookmarks();

		String bookmarks = jobCacheModel.bookmarks;

		if ((bookmarks != null) && (bookmarks.length() == 0)) {
			jobCacheModel.bookmarks = null;
		}

		return jobCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{jobId=");
		sb.append(getJobId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", salary=");
		sb.append(getSalary());
		sb.append(", bookmarks=");
		sb.append(getBookmarks());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.jobsboard.model.Job");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salary</column-name><column-value><![CDATA[");
		sb.append(getSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookmarks</column-name><column-value><![CDATA[");
		sb.append(getBookmarks());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Job.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Job.class };
	private long _jobId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _category;
	private long _originalCategory;
	private boolean _setOriginalCategory;
	private long _location;
	private long _originalLocation;
	private boolean _setOriginalLocation;
	private long _type;
	private long _originalType;
	private boolean _setOriginalType;
	private String _description;
	private String _originalDescription;
	private double _salary;
	private String _bookmarks;
	private String _originalBookmarks;
	private long _columnBitmask;
	private Job _escapedModel;
}