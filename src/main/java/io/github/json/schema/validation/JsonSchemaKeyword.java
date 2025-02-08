package io.github.json.schema.validation;

public interface JsonSchemaKeyword {
	String getKeyword();
	JsonSchemaKeywordValidator parse(String value);
}
