package org.streamframework.foundation.promise;

import java.util.concurrent.TimeUnit;

/**
 * Created by yachao on 18/5/31.
 */
public abstract class Promise<V> {

    public abstract V get();

    public abstract V get(long timeout, TimeUnit unit);

    public abstract Throwable getException();

    public static <V> Promise<V> from(/*final AsyncTask<V> task*/) {

        return null;
    }
}
