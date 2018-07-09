package com.streamframework.foundation.clean.code.control;

import org.junit.Test;
import org.streamframework.foundation.clean.code.control.Pattern;

public class PatternTest {
	
	@Test
	public void testMatch() {
		int i = 8;
		
		Pattern.of(i).matcher(x -> {
			if (x % 2 != 0) {
				System.out.println("odd");
				return true;
			}
			return false;
		}).matcher(x -> {
			if (x % 2 == 0) {
				System.out.println("even");
				return true;
			}
			return false;
		}).match();
		
	}
}
