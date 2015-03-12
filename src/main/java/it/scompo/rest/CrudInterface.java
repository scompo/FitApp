package it.scompo.rest;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudInterface< T extends BusinessObject, ID extends Serializable>{

	T getById(ID id);
	
	Page<T> getPaginated(Pageable pageable);
	
	T save(T entity);
	
	T update(ID id, T entity);

	void delete(ID id);
}
