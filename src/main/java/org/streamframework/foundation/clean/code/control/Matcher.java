package org.streamframework.foundation.clean.code.control;

@FunctionalInterface
public interface Matcher<T> {

	boolean match(T t);
}
