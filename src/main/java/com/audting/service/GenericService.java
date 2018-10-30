package com.audting.service;

public interface GenericService<T> {

	public T save(T entity);

	public T update(T entity);

	public T delete(T entity);

	public T findById(Long id);

}
