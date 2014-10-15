package br.com.rml.jpa

import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.validation.ConstraintViolationException

public class PersistenceUtils {

	protected static EntityManager entityManager

	public static EntityManager getEntityManager() {
		if (entityManager != null) {
			return entityManager
		}
		return entityManager = Persistence.createEntityManagerFactory("dojos").createEntityManager()
	}

	public static void persist(Object entity) throws ValidationException{
		EntityManager manager = getEntityManager()
		def transaction = manager.getTransaction()
		transaction.begin()
		try{
			manager.persist(entity)
		}catch(Exception e){
			transaction.rollback()
			throw e instanceof ConstraintViolationException ? new ValidationException(e): e
		}
		transaction.commit()
	}
}
