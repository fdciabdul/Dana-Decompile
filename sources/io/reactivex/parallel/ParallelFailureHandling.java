package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* loaded from: classes9.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public final ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
