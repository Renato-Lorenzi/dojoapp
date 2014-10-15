package br.com.rml.utils

import javax.persistence.EntityManager
import javax.persistence.Persistence

public class PersistenceUtils {

	protected static EntityManager entityManager

	public static EntityManager getEntityManager() {
		if (entityManager != null) {
			return entityManager
		}
		return entityManager = Persistence.createEntityManagerFactory("dojos").createEntityManager()
	}

	public static void persist(Object entity) {
		EntityManager manager = getEntityManager()
		manager.getTransaction().begin()
		manager.persist(entity)
		manager.getTransaction().commit()
	}
}
