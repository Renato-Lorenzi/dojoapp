package br.com.rml.model

import static org.assertj.core.api.Assertions.assertThat

import org.junit.Test

import br.com.rml.jpa.ValidationException

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
		try{
			participant.save()
		}catch(ValidationException e){
			assert  e.exceptions == ["name" :"não pode ser nulo"]
		}
	}
}