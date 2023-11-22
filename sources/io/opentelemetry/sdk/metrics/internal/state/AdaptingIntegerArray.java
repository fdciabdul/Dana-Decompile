package io.opentelemetry.sdk.metrics.internal.state;

import java.util.Arrays;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class AdaptingIntegerArray {
    @Nullable
    private byte[] byteBacking;
    private ArrayCellSize cellSize;
    @Nullable
    private int[] intBacking;
    @Nullable
    private long[] longBacking;
    @Nullable
    private short[] shortBacking;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum ArrayCellSize {
        BYTE,
        SHORT,
        INT,
        LONG
    }

    public AdaptingIntegerArray(int i) {
        this.cellSize = ArrayCellSize.BYTE;
        this.byteBacking = new byte[i];
    }

    private AdaptingIntegerArray(AdaptingIntegerArray adaptingIntegerArray) {
        this.cellSize = adaptingIntegerArray.cellSize;
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i == 1) {
            byte[] bArr = adaptingIntegerArray.byteBacking;
            this.byteBacking = Arrays.copyOf(bArr, bArr.length);
        } else if (i == 2) {
            short[] sArr = adaptingIntegerArray.shortBacking;
            this.shortBacking = Arrays.copyOf(sArr, sArr.length);
        } else if (i == 3) {
            int[] iArr = adaptingIntegerArray.intBacking;
            this.intBacking = Arrays.copyOf(iArr, iArr.length);
        } else if (i == 4) {
            long[] jArr = adaptingIntegerArray.longBacking;
            this.longBacking = Arrays.copyOf(jArr, jArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.opentelemetry.sdk.metrics.internal.state.AdaptingIntegerArray$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize;

        static {
            int[] iArr = new int[ArrayCellSize.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize = iArr;
            try {
                iArr[ArrayCellSize.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AdaptingIntegerArray copy() {
        return new AdaptingIntegerArray(this);
    }

    public void increment(int i, long j) {
        int i2 = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i2 == 1) {
            byte[] bArr = this.byteBacking;
            long j2 = bArr[i] + j;
            if (j2 > 127) {
                resizeToShort();
                increment(i, j);
                return;
            }
            bArr[i] = (byte) j2;
        } else if (i2 == 2) {
            short[] sArr = this.shortBacking;
            long j3 = sArr[i] + j;
            if (j3 > 32767) {
                resizeToInt();
                increment(i, j);
                return;
            }
            sArr[i] = (short) j3;
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            long[] jArr = this.longBacking;
            jArr[i] = jArr[i] + j;
        } else {
            int[] iArr = this.intBacking;
            long j4 = iArr[i] + j;
            if (j4 > 2147483647L) {
                resizeToLong();
                increment(i, j);
                return;
            }
            iArr[i] = (int) j4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long get(int i) {
        int i2;
        int i3 = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i3 == 1) {
            i2 = this.byteBacking[i];
        } else if (i3 == 2) {
            i2 = this.shortBacking[i];
        } else if (i3 != 3) {
            if (i3 != 4) {
                return 0L;
            }
            return this.longBacking[i];
        } else {
            i2 = this.intBacking[i];
        }
        return i2;
    }

    public int length() {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0;
                    }
                    return this.longBacking.length;
                }
                return this.intBacking.length;
            }
            return this.shortBacking.length;
        }
        return this.byteBacking.length;
    }

    public void clear() {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$state$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i == 1) {
            Arrays.fill(this.byteBacking, (byte) 0);
        } else if (i == 2) {
            Arrays.fill(this.shortBacking, (short) 0);
        } else if (i == 3) {
            Arrays.fill(this.intBacking, 0);
        } else if (i == 4) {
            Arrays.fill(this.longBacking, 0L);
        }
    }

    private void resizeToShort() {
        short[] sArr = new short[this.byteBacking.length];
        int i = 0;
        while (true) {
            if (i < this.byteBacking.length) {
                sArr[i] = r2[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.SHORT;
                this.shortBacking = sArr;
                this.byteBacking = null;
                return;
            }
        }
    }

    private void resizeToInt() {
        int[] iArr = new int[this.shortBacking.length];
        int i = 0;
        while (true) {
            short[] sArr = this.shortBacking;
            if (i < sArr.length) {
                iArr[i] = sArr[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.INT;
                this.intBacking = iArr;
                this.shortBacking = null;
                return;
            }
        }
    }

    private void resizeToLong() {
        long[] jArr = new long[this.intBacking.length];
        int i = 0;
        while (true) {
            if (i < this.intBacking.length) {
                jArr[i] = r2[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.LONG;
                this.longBacking = jArr;
                this.intBacking = null;
                return;
            }
        }
    }
}
