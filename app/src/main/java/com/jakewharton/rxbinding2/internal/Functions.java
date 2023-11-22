package com.jakewharton.rxbinding2.internal;

import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public final class Functions {
    private static final Always ALWAYS_TRUE;
    public static final Callable<Boolean> CALLABLE_ALWAYS_TRUE;
    public static final Predicate<Object> PREDICATE_ALWAYS_TRUE;

    static {
        Always always = new Always(Boolean.TRUE);
        ALWAYS_TRUE = always;
        CALLABLE_ALWAYS_TRUE = always;
        PREDICATE_ALWAYS_TRUE = always;
    }

    /* loaded from: classes8.dex */
    static final class Always implements Callable<Boolean>, Predicate<Object> {
        private final Boolean value;

        Always(Boolean bool) {
            this.value = bool;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            return this.value;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object obj) throws Exception {
            return this.value.booleanValue();
        }
    }

    private Functions() {
        throw new AssertionError("No instances.");
    }
}
