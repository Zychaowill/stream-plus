package org.streamframework.foundation.promise;

import java.util.concurrent.TimeUnit;

/**
 * Created by yachao on 18/6/1.
 */
public class DefaultPromise<V> extends Promise<V> {

    @Override
    public V get() {
        return null;
    }

    @Override
    public V get(long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public Throwable getException() {
        return null;
    }
}
