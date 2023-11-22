package io.opentelemetry.sdk.internal;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class PrimitiveLongList {
    public static List<Long> wrap(long[] jArr) {
        return new LongListImpl(jArr);
    }

    public static long[] toArray(List<Long> list) {
        if (!(list instanceof LongListImpl)) {
            int size = list.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = list.get(i).longValue();
            }
            return jArr;
        }
        return ((LongListImpl) list).values;
    }

    /* loaded from: classes9.dex */
    static class LongListImpl extends AbstractList<Long> {
        private final long[] values;

        LongListImpl(long[] jArr) {
            this.values = jArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i) {
            return Long.valueOf(this.values[i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof LongListImpl)) {
                return super.equals(obj);
            }
            return Arrays.equals(this.values, ((LongListImpl) obj).values);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return Arrays.hashCode(this.values);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.values.length;
        }
    }

    private PrimitiveLongList() {
    }
}
