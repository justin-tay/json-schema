package io.github.json.schema.path;

public class UriReference extends JsonNodePath {
	private static final UriReference ROOT = new UriReference();

	public static UriReference atRoot() {
		return ROOT;
	}

	public UriReference() {
		super();
	}

	public UriReference(JsonNodePath parent, int pathSegmentIndex) {
		super(parent, pathSegmentIndex);
	}

	public UriReference(JsonNodePath parent, String pathSegment) {
		super(parent, pathSegment);
	}

	@Override
	public UriReference append(String token) {
		return new UriReference(this, token);
	}

	@Override
	public UriReference append(int index) {
		return new UriReference(this, index);
	}

	@Override
	public PathType getPathType() {
		return PathType.URI_REFERENCE;
	}
}
