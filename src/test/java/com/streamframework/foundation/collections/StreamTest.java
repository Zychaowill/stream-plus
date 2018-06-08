package com.streamframework.foundation.collections;

import java.util.Objects;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamTest {

	@Test
	public void testListStreamOf() {
		
		Stream.empty().filter(Objects::nonNull).anyMatch(Objects::nonNull);

		// will generate NullPointerException
		Stream.of(null).anyMatch(Objects::isNull);
		
		log.info("Success.");
	}
}
