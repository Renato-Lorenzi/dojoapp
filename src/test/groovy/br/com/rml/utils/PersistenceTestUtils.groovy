package br.com.rml.utils;

import javax.persistence.Persistence

import br.com.rml.jpa.PersistenceUtils

public class PersistenceTestUtils extends PersistenceUtils {

	private static final String FILE_DB = "C:/temp/test2.db";

	/**
	 * Creates the entity manager that connects for test
	 */
	public static void createEntityManagerForTest() {
		if (entityManager != null) {
			return
		}
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		properties.put("javax.persistence.jdbc.url", "jdbc:h2:file:" + FILE_DB);
		entityManager = Persistence.createEntityManagerFactory("dojos", properties).createEntityManager();
	}

	/**
	 * Destroy entity manager and deletes the db file
	 */
	public static void destroyEntityManagerForTest() {
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery("DROP ALL OBJECTS").executeUpdate();
		entityManager.getTransaction().commit();
	}
}
