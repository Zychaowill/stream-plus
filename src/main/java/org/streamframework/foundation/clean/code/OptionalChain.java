package org.streamframework.foundation.clean.code;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface OptionalChain<T> {

	OptionalChain<T> is(Predicate<T> t);
	
	<IN, OUT> OptionalChain get(Function<IN, OUT> fetcher);
	
	OptionalChain<T> get(Object value);
	
	OptionalChain<T> or();
	
	OptionalChain<T> isNull();
	
	OptionalChain<T> nonNull();
	
	List<Object> get();
}
