package org.streamframework.foundation.clean.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DefaultOptionalChain<T> implements OptionalChain<T> {

	private T value;
	private List<Boolean> isLabels = new ArrayList<>();
	private List<Object> values = new ArrayList<>();
	
	private DefaultOptionalChain(T value) {
		this.value = value;
	}
	
	public static <T> DefaultOptionalChain<T> of(T value) {
		DefaultOptionalChain<T> chain = new DefaultOptionalChain<>(value);
		return chain;
	}
	
	@Override
	public OptionalChain<T> is(Predicate<T> t) {
		isLabels.add(t.test((T) value));
		return this;
	}

	@Override
	public <IN, OUT> OptionalChain<T> get(Function<IN, OUT> fetcher) {
		values.add(fetcher.apply((IN) value));
		return this;
	}

	@Override
	public OptionalChain<T> get(Object value) {
		values.add(value);
		return this;
	}

	@Override
	public OptionalChain<T> or() {
		return this;
	}

	@Override
	public OptionalChain<T> isNull() {
		isLabels.add((value == null));
		return this;
	}

	@Override
	public OptionalChain<T> nonNull() {
		isLabels.add((value != null));
		return this;
	}

	@Override
	public List<Object> get() {
		List<Object> results = new ArrayList<>();
		for (int i = 0; i < isLabels.size(); i++) {
			if (isLabels.get(i)) {
				results.add(values.get(i));
			}
		}
		return results;
	}
}
