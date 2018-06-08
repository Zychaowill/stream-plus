package org.streamframework.foundation.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class MapHelper {

	<K, V, ID> Map<ID, List<Map<K, V>>> groupBy(List<Map<K, V>> elements, Function<Map<K, V>, ID> keyExtractor) {
		if (CollectionUtils.isEmpty(elements)) {
			return new HashMap<>(0);
		}
		return elements.stream().collect(Collectors.groupingBy(keyExtractor));
	}
}
