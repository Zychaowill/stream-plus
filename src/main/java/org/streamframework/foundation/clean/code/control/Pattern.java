package org.streamframework.foundation.clean.code.control;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to  
 * @author jangz
 * @since
 */
public class Pattern<T> {
	
	private T t;
	
	private List<Matcher<T>> matches;
	
	private Pattern(T t) {
		this.t = t;
		this.matches = new ArrayList<>();
	}
	
	public static <T> Pattern<T> of(T t) {
		return new Pattern<T>(t);
	}
	
	public Pattern<T> matcher(Matcher<T> matcher) {
		matches.add(matcher);
		return this;
	}
	
	public void match() {
		for (Matcher<T> matcher : matches) {
			if (matcher.match(t)) {
				break;
			}
		}
	}
}
