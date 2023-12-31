package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class Count implements Serializable {
    private int value;

    Count(int i) {
        this.value = i;
    }

    public final int get() {
        return this.value;
    }

    public final void add(int i) {
        this.value += i;
    }

    public final int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    public final void set(int i) {
        this.value = i;
    }

    public final int getAndSet(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    public final int hashCode() {
        return this.value;
    }

    public final boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public final String toString() {
        return Integer.toString(this.value);
    }
}
