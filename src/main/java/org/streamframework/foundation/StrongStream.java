package org.streamframework.foundation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public interface StrongStream<ID, D, T> extends AdvancedStream {

	public static <E> Stream<E> stream(List<E> list) {
		if (CollectionUtils.isEmpty(list)) {
			return Stream.empty();
		}
		return list.stream();
	}
	
	@SuppressWarnings("unchecked")
	public static <E> Stream<E> elementStream(E... args) {
		if (ArrayUtils.isEmpty(args)) {
			return Stream.empty();
		}
		return Arrays.stream(args);
	}
	
	
	/**
	 * select results from list where key 
	 */
	StrongStream<ID, D, T> templates(List<T> templates);
	
	StrongStream<ID, D, T> filter(Function<T, ID> filterExtractor);

	StrongStream<ID, D, T> datas(List<D> datas);

	StrongStream<ID, D, T> key(Function<D, ID> keyExtractor);

	List<D> collect();
}
