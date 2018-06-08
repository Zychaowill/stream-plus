package org.streamframework.foundation.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class ListHelper {

    public <T> Map<T, Boolean> transform(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new HashMap<>(0);
        }
        Boolean empty = Boolean.TRUE;
        Map<T, Boolean> targets = new HashMap<>(list.size());
        for (T t : list) {
            targets.put(t, empty);
        }
        return targets;
    }

    @SuppressWarnings("unchecked")
	public <T> Map<T, Boolean> transform(T... args) {
        if (ArrayUtils.isEmpty(args)) {
            return new HashMap<>(0);
        }
        Boolean empty = Boolean.TRUE;
        return Arrays.stream(args)
                .filter(Objects::nonNull)
                .collect(HashMap::new, (m, v) -> m.put(v, empty), HashMap::putAll);
    }
    
    public <T> HashSet<T> toHashSet(List<T> list) {
    	if (CollectionUtils.isEmpty(list)) {
    		return new HashSet<>(0);
    	}
    	return list.stream().collect(Collectors.toCollection(HashSet::new));
    }
    
    @SuppressWarnings("unchecked")
	public <T> HashSet<T> toHashSet(T... args) {
    	if (ArrayUtils.isEmpty(args)) {
    		return new HashSet<>(0);
    	}
    	return toHashSet(Arrays.asList(args));
    }
    
    public <T, ID> Predicate<T> distinctBy(Function<T, ID> keyExtractor) {
    	Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    	return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    
    public <T, ID> Map<ID, List<T>> groupBy(List<T> list, Function<T, ID> keyExtractor) {
    	if (CollectionUtils.isEmpty(list)) {
    		return new HashMap<>(0);
    	}
    	return list.stream().collect(Collectors.groupingBy(keyExtractor));
    }
}
