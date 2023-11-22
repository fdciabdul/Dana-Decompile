package io.split.android.client.service.impressions;

/* loaded from: classes6.dex */
public class ImpressionManagerConfig {
    private final long mImpressionsChunkSize;
    private final long mImpressionsCounterRefreshRate;
    private final Mode mImpressionsMode;
    private final int mImpressionsQueueSize;
    private final long mImpressionsRefreshRate;
    private final long mUniqueKeysRefreshRate;

    public ImpressionManagerConfig(long j, long j2, ImpressionsMode impressionsMode, int i, long j3, long j4) {
        this(j, j2, Mode.fromImpressionMode(impressionsMode), i, j3, j4);
    }

    public ImpressionManagerConfig(long j, long j2, Mode mode, int i, long j3, long j4) {
        this.mImpressionsRefreshRate = j;
        this.mImpressionsCounterRefreshRate = j2;
        this.mImpressionsMode = mode;
        this.mImpressionsQueueSize = i;
        this.mImpressionsChunkSize = j3;
        this.mUniqueKeysRefreshRate = j4;
    }

    public long getImpressionsRefreshRate() {
        return this.mImpressionsRefreshRate;
    }

    public long getImpressionsCounterRefreshRate() {
        return this.mImpressionsCounterRefreshRate;
    }

    public Mode getImpressionsMode() {
        return this.mImpressionsMode;
    }

    public int getImpressionsQueueSize() {
        return this.mImpressionsQueueSize;
    }

    public long getImpressionsChunkSize() {
        return this.mImpressionsChunkSize;
    }

    public long getUniqueKeysRefreshRate() {
        return this.mUniqueKeysRefreshRate;
    }

    /* loaded from: classes6.dex */
    public enum Mode {
        OPTIMIZED,
        DEBUG,
        NONE;

        public static Mode fromImpressionMode(ImpressionsMode impressionsMode) {
            if (impressionsMode == ImpressionsMode.DEBUG) {
                return DEBUG;
            }
            if (impressionsMode == ImpressionsMode.NONE) {
                return NONE;
            }
            return OPTIMIZED;
        }

        public final boolean isDebug() {
            return this == DEBUG;
        }

        public final boolean isNone() {
            return this == NONE;
        }

        public final boolean isOptimized() {
            return this == OPTIMIZED;
        }
    }
}
