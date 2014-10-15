package br.com.rml.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.xml.bind.annotation.XmlRootElement

import br.com.rml.jpa.ActiveRecord

/**
 * Person who participates in a Dojo. This person can be Sensei, participant or
 * moderator.
 * 
 * @author Renato
 */
@Entity
@XmlRootElement
public class Participant extends ActiveRecord<Participant>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id

	@NotNull
	private String name
}
