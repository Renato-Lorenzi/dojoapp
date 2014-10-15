package br.com.rml.jpa

import javax.validation.ConstraintViolationException

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Exception on validation entity
 * @author Renato
 *
 */
public class ValidationException extends Exception {

	Map<String, String> exceptions = new LinkedHashMap<String,String>()

	public ValidationException(ConstraintViolationException ex) {
		ex.constraintViolations.each { it ->

			exceptions.put(it.propertyPath.toString(), it.message)
		}
	}

	public String toJson() {
		def mapper = new ObjectMapper()
		return mapper.writeValueAsString(exceptions)
	}
}
