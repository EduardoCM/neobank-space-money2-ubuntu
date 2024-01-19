package com.neobank.spacemoney.service;

public interface PersistService<T> {

	public void create(T t);

	public T findById(Integer id);

}
