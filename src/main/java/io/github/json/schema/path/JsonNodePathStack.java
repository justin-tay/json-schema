package io.github.json.schema.path;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracks the json node path during execution.
 */
public class JsonNodePathStack {
	private final List<Object> segments;

	public JsonNodePathStack() {
		this.segments = new ArrayList<>();
	}

	public void push(String segment) {
		this.segments.add(segment);
	}

	public void push(Integer segment) {
		this.segments.add(segment);
	}

	public void pop() {
		this.segments.remove(this.segments.size() - 1);
	}

	@Override
	public String toString() {
		return segments.toString();
	}
}
