package io.github.json.schema.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import io.github.json.schema.JsonSchema;
import io.github.json.schema.path.JsonNodePathStack;

public class JsonSchemaParser {
	JsonSchema parse(InputStream inputStream) throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		try(JsonParser jsonParser = jsonFactory.createParser(inputStream)) {
			return parse(jsonParser);
		}
	}
	
	enum State {
		ARRAY,
		OBJECT,
		FIELD
	}

	JsonSchema parse(JsonParser jsonParser) throws IOException {
		Deque<State> state = new ArrayDeque<>();
		JsonToken token = null;
		JsonNodePathStack jsonNodePath = new JsonNodePathStack();
		while ((token = jsonParser.nextToken()) != null) {
			State current = state.peek();
			if (current != null) {
				switch (current) {
				case FIELD:
					switch (token) {
					case FIELD_NAME:
						jsonNodePath.pop();
						String fieldName = jsonParser.currentName();
						jsonNodePath.push(fieldName);
						System.out.println(jsonNodePath);
						continue;
					case END_OBJECT:
						jsonNodePath.pop();
						state.pop(); // pop field
						state.pop(); // pop object
						continue;
					case START_OBJECT:
						state.push(State.OBJECT);
						continue;
					default:
						continue;
					}
				case OBJECT:
					switch (token) {
					case FIELD_NAME:
						String fieldName = jsonParser.currentName();
						jsonNodePath.push(fieldName);
						state.push(State.FIELD);
						System.out.println(jsonNodePath);
						continue;
					case END_OBJECT:
						state.pop(); // pop object
						continue;
					default:
						continue;
					}
				case ARRAY:
					continue;
				default:
					break;
				}
			}
			
			switch (token) {
			case START_ARRAY:
				state.push(State.ARRAY);
				break;
			case START_OBJECT:
				state.push(State.OBJECT);
				break;
			default:
				break;
			}
		}
		return null;
	}
}
