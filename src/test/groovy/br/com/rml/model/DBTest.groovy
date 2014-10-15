package br.com.rml.model;

import org.junit.After
import org.junit.Before

import br.com.rml.utils.PersistenceTestUtils

public class DBTest {

	@Before
	public void before() {
		PersistenceTestUtils.createEntityManagerForTest()
	}

	@After
	public void after() {
		PersistenceTestUtils.destroyEntityManagerForTest()
	}
}
