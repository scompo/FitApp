package it.scompo.rest;

import java.io.Serializable;

public interface CrudController<T extends BusinessObject, ID extends Serializable> extends CrudInterface<T, Long> {

}
