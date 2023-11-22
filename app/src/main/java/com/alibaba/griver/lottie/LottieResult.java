package com.alibaba.griver.lottie;

import java.util.Arrays;

/* loaded from: classes6.dex */
public final class LottieResult<V> {
    private final Throwable exception;
    private final V value;

    public LottieResult(V v) {
        this.value = v;
        this.exception = null;
    }

    public LottieResult(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    public final V getValue() {
        return this.value;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LottieResult) {
            LottieResult lottieResult = (LottieResult) obj;
            if (getValue() == null || !getValue().equals(lottieResult.getValue())) {
                if (getException() == null || lottieResult.getException() == null) {
                    return false;
                }
                return getException().toString().equals(getException().toString());
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
