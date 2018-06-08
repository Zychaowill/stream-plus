package org.streamframework.foundation;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class DefaultStrongStream<ID, D, T> implements StrongStream<ID, D, T> {

	private Function<D, ID> keyExtractor;
	private Function<T, ID> filterExtractor; 
	private List<D> datas;
	private List<T> templates;

	@Override
	public StrongStream<ID, D, T> templates(List<T> templates) {
		this.templates = templates;
		return this;
	}

	@Override
	public StrongStream<ID, D, T> filter(Function<T, ID> filterExtractor) {
		this.filterExtractor = filterExtractor;
		return this;
	}
	
	@Override
	public StrongStream<ID, D, T> datas(List<D> datas) {
		this.datas = datas;
		return this;
	}

	@Override
	public StrongStream<ID, D, T> key(Function<D, ID> keyExtractor) {
		this.keyExtractor = keyExtractor;
		return this;
	}

	@Override
	public List<D> collect() {
		if (CollectionUtils.isEmpty(datas) || Objects.isNull(keyExtractor) || CollectionUtils.isEmpty(templates)) {
			return datas;
		}
		
		if (Objects.isNull(filterExtractor)) {
			return directlyFilter();
		}
		return mapAndFilter();
	}

	private List<D> mapAndFilter() {
		HashSet<ID> targets = templates.stream().map(t -> filterExtractor.apply(t)).collect(Collectors.toCollection(HashSet::new));
		return datas.stream().filter(v -> targets.contains(keyExtractor.apply(v))).collect(Collectors.toList());
	}

	private List<D> directlyFilter() {
		HashSet<T> targets = templates.stream().collect(Collectors.toCollection(HashSet::new));
		return datas.stream().filter(v -> targets.contains(keyExtractor.apply(v))).collect(Collectors.toList());
	}

	/*private boolean inSimpleClass(Class<?> cls) {
		return Sets
				.newConcurrentHashSet(Arrays.asList(Boolean.class, Byte.class, Character.class, Short.class, Integer.class, Float.class, Long.class, Double.class))
				.contains(cls);
	}*/
}
