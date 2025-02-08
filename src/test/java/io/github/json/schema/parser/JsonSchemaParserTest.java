package io.github.json.schema.parser;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;

public class JsonSchemaParserTest {
	@Test
	void test() throws JsonParseException, IOException {
		InputStream inputStream = JsonSchemaParserTest.class.getClassLoader().getResourceAsStream("schema/adf.json");
		JsonSchemaParser parser = new JsonSchemaParser();
		parser.parse(inputStream);
	}
}
