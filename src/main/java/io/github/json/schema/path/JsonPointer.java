package io.github.json.schema.path;

public class JsonPointer extends JsonNodePath {
	private static final JsonPointer ROOT = new JsonPointer();

	public static JsonPointer atRoot() {
		return ROOT;
	}

	public JsonPointer() {
		super();
	}

	public JsonPointer(JsonNodePath parent, int pathSegmentIndex) {
		super(parent, pathSegmentIndex);
	}

	public JsonPointer(JsonNodePath parent, String pathSegment) {
		super(parent, pathSegment);
	}

	@Override
	public JsonPointer append(String token) {
		return new JsonPointer(this, token);
	}

	@Override
	public JsonPointer append(int index) {
		return new JsonPointer(this, index);
	}

	@Override
	public PathType getPathType() {
		return PathType.JSON_POINTER;
	}
}
