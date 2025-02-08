package io.github.json.schema.validation;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonSchemaValidator {
	void validate(InputStream inputStream) throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		try(JsonParser jsonParser = jsonFactory.createParser(inputStream)) {
			JsonToken token = jsonParser.nextToken();
			switch(token) {
			case START_ARRAY:
				token = jsonParser.nextToken();
				while (token != JsonToken.END_ARRAY) {
					
				}
				break;
			case START_OBJECT:
				token = jsonParser.nextToken();
				while (token != JsonToken.END_OBJECT) {
					
				}
				break;
			default:
				break;
			}
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				
			}
		}
	}
}
