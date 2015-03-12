package it.scompo.rest;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractCrudService<T extends BusinessObject, ID extends Serializable>
		implements CrudService<T, ID> {

	private PagingAndSortingRepository<T, ID> repository;
	
	public T getById(ID id){
		
		return repository.findOne(id);
	}
	
	public Page<T> getPaginated(Pageable pageable){
		
		return repository.findAll(pageable);
	}
	
	public T save(T entity){
		
		return repository.save(entity);
	}
	
	public T update(ID id, T entity){
		
		T dao = getById(id);
		
		updateObject(entity, dao);
		
		return save(dao);
	}
	
	public abstract void updateObject(T entity, T dao);

	public void delete(ID id){
		
		repository.delete(id);
	}

	public PagingAndSortingRepository<T, ID> getRepository() {
		return repository;
	}

	public void setRepository(PagingAndSortingRepository<T, ID> repository) {
		this.repository = repository;
	}
	
}
