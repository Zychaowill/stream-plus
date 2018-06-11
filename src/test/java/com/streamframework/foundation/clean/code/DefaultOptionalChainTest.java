package com.streamframework.foundation.clean.code;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.streamframework.foundation.clean.code.DefaultOptionalChain;

public class DefaultOptionalChainTest {

	@Test
	public void testDefaultOptionalChain() {
		List<Object> results = DefaultOptionalChain.of(1)
				.is(i -> i % 2 == 0).get(new Integer(1))
				.or()
				.is(i -> i - 2 <= 0).get(3).get();
		if (CollectionUtils.isNotEmpty(results)) {
			System.out.printf("Has %d result.\n", results.size());
			for (Object o : results) {
				System.out.printf("result is %s.\n", o);
			}
		}
	}
}
