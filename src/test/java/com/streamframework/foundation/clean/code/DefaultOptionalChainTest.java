package com.streamframework.foundation.clean.code;

import org.junit.Test;
import org.streamframework.foundation.clean.code.DefaultOptionalChain;

public class DefaultOptionalChainTest {

	@Test
	public void testDefaultOptionalChain() {
		DefaultOptionalChain.of(1).is(i -> i % 2 == 0);
	}
}
