package br.com.rml.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.PrimaryKeyJoinColumn
import javax.xml.bind.annotation.XmlRootElement

/**
 * This entity represents the Dojo event
 * 
 * @author Renato
 *
 */
@Entity
@XmlRootElement
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
	private Participant sensei

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
	private Participant moderator

	/**
	 * For this relationship will be created the join table "participant_dojo"
	 * http://en.wikibooks.org/wiki/Java_Persistence/ManyToMany
	 */
	@ManyToMany
	@JoinTable(name = "participant_dojo",
	joinColumns = [@JoinColumn(name = "dojo_id", referencedColumnName = "id")])
	private List<Participant> participants

	private String dateTime
	private String dojoLink
	private String challengeLink
	private String costCenter
}
