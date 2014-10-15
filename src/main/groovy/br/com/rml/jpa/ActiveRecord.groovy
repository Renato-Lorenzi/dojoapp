package br.com.rml.jpa

import java.lang.reflect.ParameterizedType

import javax.validation.ConstraintViolationException

/**
 * The base class to Model classes.
 * 
 * Your methods are based on:
 * http://api.rubyonrails.org/classes/ActiveRecord/Base.html
 * 
 * @author Renato
 *
 * @param <T>
 */
public abstract class ActiveRecord<T> {
	private Class<T> genericClass

	public ActiveRecord() {
		genericClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]
	}

	/**
	 * Save this record on DB
	 * 
	 * @throws ValidationException error on validate register
	 */

	public void save() throws ValidationException{
		PersistenceUtils.persist(this)
	}

	/**
	 * 
	 * @return All from table
	 */
	public List<T> all() {
		return PersistenceUtils
		.getEntityManager()
		.createQuery("SELECT t FROM " + getGenericClassName() + " t",
		genericClass).resultList
	}

	/**
	 * 
	 * @return only one from table. Is required that table should have only one
	 *         record
	 */
	public T first() {
		return all().first()
	}

	protected String getGenericClassName() {
		return genericClass.getSimpleName()
	}
}
