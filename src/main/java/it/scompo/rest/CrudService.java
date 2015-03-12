package it.scompo.rest;

import java.io.Serializable;

public interface CrudService<T extends BusinessObject, ID extends Serializable>
		extends CrudInterface<T, ID> {

}
