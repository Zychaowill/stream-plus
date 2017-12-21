package org.streamframework.foundation;

import java.util.stream.Stream;

public interface AdvancedStream<T> extends Stream<T> {
	
	public static <T> AdvancedStream<T> of(T t) {
		return null;
	}
}
