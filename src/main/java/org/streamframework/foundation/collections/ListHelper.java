package org.streamframework.foundation.collections;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

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

    public <T> Map<T, Boolean> transform(T... args) {
        if (ArrayUtils.isEmpty(args)) {
            return new HashMap<>(0);
        }
        Boolean empty = Boolean.TRUE;
        return Arrays.stream(args)
                .filter(Objects::nonNull)
                .collect(HashMap::new, (m, v) -> m.put(v, empty), HashMap::putAll);
    }
}
