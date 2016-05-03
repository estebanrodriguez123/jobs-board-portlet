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

package com.rivetlogic.jobsboard.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rivetlogic.jobsboard.model.Applicant;
import com.rivetlogic.jobsboard.service.ApplicantLocalService;
import com.rivetlogic.jobsboard.service.persistence.ApplicantPersistence;
import com.rivetlogic.jobsboard.service.persistence.JobPersistence;
import com.rivetlogic.jobsboard.service.persistence.SubscriptionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the applicant local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rivetlogic.jobsboard.service.impl.ApplicantLocalServiceImpl}.
 * </p>
 *
 * @author joseross
 * @see com.rivetlogic.jobsboard.service.impl.ApplicantLocalServiceImpl
 * @see com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil
 * @generated
 */
public abstract class ApplicantLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ApplicantLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rivetlogic.jobsboard.service.ApplicantLocalServiceUtil} to access the applicant local service.
	 */

	/**
	 * Adds the applicant to the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicant the applicant
	 * @return the applicant that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Applicant addApplicant(Applicant applicant)
		throws SystemException {
		applicant.setNew(true);

		return applicantPersistence.update(applicant);
	}

	/**
	 * Creates a new applicant with the primary key. Does not add the applicant to the database.
	 *
	 * @param applicantId the primary key for the new applicant
	 * @return the new applicant
	 */
	@Override
	public Applicant createApplicant(long applicantId) {
		return applicantPersistence.create(applicantId);
	}

	/**
	 * Deletes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant that was removed
	 * @throws PortalException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Applicant deleteApplicant(long applicantId)
		throws PortalException, SystemException {
		return applicantPersistence.remove(applicantId);
	}

	/**
	 * Deletes the applicant from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicant the applicant
	 * @return the applicant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Applicant deleteApplicant(Applicant applicant)
		throws SystemException {
		return applicantPersistence.remove(applicant);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Applicant.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return applicantPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return applicantPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return applicantPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return applicantPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return applicantPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Applicant fetchApplicant(long applicantId) throws SystemException {
		return applicantPersistence.fetchByPrimaryKey(applicantId);
	}

	/**
	 * Returns the applicant with the primary key.
	 *
	 * @param applicantId the primary key of the applicant
	 * @return the applicant
	 * @throws PortalException if a applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Applicant getApplicant(long applicantId)
		throws PortalException, SystemException {
		return applicantPersistence.findByPrimaryKey(applicantId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return applicantPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.jobsboard.model.impl.ApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of applicants
	 * @param end the upper bound of the range of applicants (not inclusive)
	 * @return the range of applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Applicant> getApplicants(int start, int end)
		throws SystemException {
		return applicantPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of applicants.
	 *
	 * @return the number of applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getApplicantsCount() throws SystemException {
		return applicantPersistence.countAll();
	}

	/**
	 * Updates the applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param applicant the applicant
	 * @return the applicant that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Applicant updateApplicant(Applicant applicant)
		throws SystemException {
		return applicantPersistence.update(applicant);
	}

	/**
	 * Returns the applicant local service.
	 *
	 * @return the applicant local service
	 */
	public com.rivetlogic.jobsboard.service.ApplicantLocalService getApplicantLocalService() {
		return applicantLocalService;
	}

	/**
	 * Sets the applicant local service.
	 *
	 * @param applicantLocalService the applicant local service
	 */
	public void setApplicantLocalService(
		com.rivetlogic.jobsboard.service.ApplicantLocalService applicantLocalService) {
		this.applicantLocalService = applicantLocalService;
	}

	/**
	 * Returns the applicant persistence.
	 *
	 * @return the applicant persistence
	 */
	public ApplicantPersistence getApplicantPersistence() {
		return applicantPersistence;
	}

	/**
	 * Sets the applicant persistence.
	 *
	 * @param applicantPersistence the applicant persistence
	 */
	public void setApplicantPersistence(
		ApplicantPersistence applicantPersistence) {
		this.applicantPersistence = applicantPersistence;
	}

	/**
	 * Returns the job local service.
	 *
	 * @return the job local service
	 */
	public com.rivetlogic.jobsboard.service.JobLocalService getJobLocalService() {
		return jobLocalService;
	}

	/**
	 * Sets the job local service.
	 *
	 * @param jobLocalService the job local service
	 */
	public void setJobLocalService(
		com.rivetlogic.jobsboard.service.JobLocalService jobLocalService) {
		this.jobLocalService = jobLocalService;
	}

	/**
	 * Returns the job persistence.
	 *
	 * @return the job persistence
	 */
	public JobPersistence getJobPersistence() {
		return jobPersistence;
	}

	/**
	 * Sets the job persistence.
	 *
	 * @param jobPersistence the job persistence
	 */
	public void setJobPersistence(JobPersistence jobPersistence) {
		this.jobPersistence = jobPersistence;
	}

	/**
	 * Returns the subscription local service.
	 *
	 * @return the subscription local service
	 */
	public com.rivetlogic.jobsboard.service.SubscriptionLocalService getSubscriptionLocalService() {
		return subscriptionLocalService;
	}

	/**
	 * Sets the subscription local service.
	 *
	 * @param subscriptionLocalService the subscription local service
	 */
	public void setSubscriptionLocalService(
		com.rivetlogic.jobsboard.service.SubscriptionLocalService subscriptionLocalService) {
		this.subscriptionLocalService = subscriptionLocalService;
	}

	/**
	 * Returns the subscription persistence.
	 *
	 * @return the subscription persistence
	 */
	public SubscriptionPersistence getSubscriptionPersistence() {
		return subscriptionPersistence;
	}

	/**
	 * Sets the subscription persistence.
	 *
	 * @param subscriptionPersistence the subscription persistence
	 */
	public void setSubscriptionPersistence(
		SubscriptionPersistence subscriptionPersistence) {
		this.subscriptionPersistence = subscriptionPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rivetlogic.jobsboard.model.Applicant",
			applicantLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rivetlogic.jobsboard.model.Applicant");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Applicant.class;
	}

	protected String getModelClassName() {
		return Applicant.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = applicantPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rivetlogic.jobsboard.service.ApplicantLocalService.class)
	protected com.rivetlogic.jobsboard.service.ApplicantLocalService applicantLocalService;
	@BeanReference(type = ApplicantPersistence.class)
	protected ApplicantPersistence applicantPersistence;
	@BeanReference(type = com.rivetlogic.jobsboard.service.JobLocalService.class)
	protected com.rivetlogic.jobsboard.service.JobLocalService jobLocalService;
	@BeanReference(type = JobPersistence.class)
	protected JobPersistence jobPersistence;
	@BeanReference(type = com.rivetlogic.jobsboard.service.SubscriptionLocalService.class)
	protected com.rivetlogic.jobsboard.service.SubscriptionLocalService subscriptionLocalService;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ApplicantLocalServiceClpInvoker _clpInvoker = new ApplicantLocalServiceClpInvoker();
}