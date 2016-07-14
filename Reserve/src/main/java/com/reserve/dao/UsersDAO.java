package com.reserve.dao;

import java.util.List;

import com.reserve.dao.entity.Users;

public interface UsersDAO {

	public abstract void save(Users transientInstance);

	public abstract void delete(Users persistentInstance);

	public abstract Users findById(java.lang.Integer id);

	public abstract List findByExample(Users instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsername(Object username);

	public abstract List findByPassword(Object password);

	public abstract List findAll();

	public abstract Users merge(Users detachedInstance);

	public abstract void attachDirty(Users instance);

	public abstract void attachClean(Users instance);

}