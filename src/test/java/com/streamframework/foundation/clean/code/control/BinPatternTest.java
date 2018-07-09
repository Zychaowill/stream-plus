package com.streamframework.foundation.clean.code.control;

import org.junit.Test;
import org.streamframework.foundation.clean.code.control.BinPattern;

public class BinPatternTest {
	
	@Test
	public void testBinPattern() {
		BinPattern.of(8)
			.is(i -> i % 2 != 0)
			.success(() -> System.out.println("Success."))
			.error(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.print("." + " ");
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println();
			}).execute();
	}
}
