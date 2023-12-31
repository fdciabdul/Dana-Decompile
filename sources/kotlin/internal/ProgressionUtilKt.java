package kotlin.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u001a'\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\u0007\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000e"}, d2 = {"", "a", "b", "c", "differenceModulo", "(III)I", "", "(JJJ)J", "start", "end", "step", "getProgressionLastElement", "mod", "(II)I", "(JJ)J"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressionUtilKt {
    private static final int mod(int i, int i2) {
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    private static final long mod(long j, long j2) {
        long j3 = j % j2;
        return j3 < 0 ? j3 + j2 : j3;
    }

    private static final int differenceModulo(int i, int i2, int i3) {
        return mod(mod(i, i3) - mod(i2, i3), i3);
    }

    private static final long differenceModulo(long j, long j2, long j3) {
        return mod(mod(j, j3) - mod(j2, j3), j3);
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            return i < i2 ? i2 - differenceModulo(i2, i, i3) : i2;
        } else if (i3 < 0) {
            return i > i2 ? i2 + differenceModulo(i, i2, -i3) : i2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long getProgressionLastElement(long j, long j2, long j3) {
        if (j3 > 0) {
            return j < j2 ? j2 - differenceModulo(j2, j, j3) : j2;
        } else if (j3 < 0) {
            return j > j2 ? j2 + differenceModulo(j, j2, -j3) : j2;
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
