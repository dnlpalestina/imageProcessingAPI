package com.palestina.imageProcessingAPI.models.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmailConverter implements AttributeConverter<List<String>, String> {

	private static final Logger logger = LoggerFactory.getLogger(EmailConverter.class);
	private final TypeReference<List<String>> listTypeRef = new TypeReference<List<String>>() {
	};
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		try {
			String string = mapper.writeValueAsString(attribute);
			return string;
		} catch (JsonProcessingException e) {
			logger.error("An error occured when parse emails: ", e);
			return null;
		}
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		List<String> emails = null;
		try {
			emails = mapper.readValue(dbData, listTypeRef);
		} catch (JsonProcessingException e) {
			logger.error("An error occured when parse emails: ", e);
		}
		return emails;
	}

}
