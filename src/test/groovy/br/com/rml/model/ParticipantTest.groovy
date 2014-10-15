package br.com.rml.model

import static org.assertj.core.api.Assertions.assertThat

import org.junit.Test

import br.com.rml.utils.PersistenceUtils

public class ParticipantTest extends DBTest {

	@Test
	public void testInsert() {
		Participant participant = new Participant()
		participant.name = "joao"
		participant.save()
		assert participant == participant.first()
	}

	@Test
	public void testInsertWithError() {
		Participant participant = new Participant()
		participant.save()
	}
}
