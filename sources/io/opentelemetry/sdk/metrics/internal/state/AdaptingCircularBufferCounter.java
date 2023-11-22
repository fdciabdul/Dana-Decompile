package io.opentelemetry.sdk.metrics.internal.state;

/* loaded from: classes6.dex */
public class AdaptingCircularBufferCounter implements ExponentialCounter {
    private static final int NULL_INDEX = Integer.MIN_VALUE;
    private final AdaptingIntegerArray backing;
    private int baseIndex;
    private int endIndex;
    private int startIndex;

    public AdaptingCircularBufferCounter(int i) {
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.backing = new AdaptingIntegerArray(i);
    }

    public AdaptingCircularBufferCounter(ExponentialCounter exponentialCounter) {
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        if (exponentialCounter instanceof AdaptingCircularBufferCounter) {
            AdaptingCircularBufferCounter adaptingCircularBufferCounter = (AdaptingCircularBufferCounter) exponentialCounter;
            this.backing = adaptingCircularBufferCounter.backing.copy();
            this.startIndex = exponentialCounter.getIndexStart();
            this.endIndex = exponentialCounter.getIndexEnd();
            this.baseIndex = adaptingCircularBufferCounter.baseIndex;
            return;
        }
        this.backing = new AdaptingIntegerArray(exponentialCounter.getMaxSize());
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.endIndex = Integer.MIN_VALUE;
        for (int indexStart = exponentialCounter.getIndexStart(); indexStart <= exponentialCounter.getIndexEnd(); indexStart++) {
            increment(indexStart, exponentialCounter.get(indexStart));
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexStart() {
        return this.startIndex;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexEnd() {
        return this.endIndex;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean increment(int i, long j) {
        if (this.baseIndex == Integer.MIN_VALUE) {
            this.startIndex = i;
            this.endIndex = i;
            this.baseIndex = i;
            this.backing.increment(0, j);
            return true;
        }
        int i2 = this.endIndex;
        if (i > i2) {
            if ((i - this.startIndex) + 1 > this.backing.length()) {
                return false;
            }
            this.endIndex = i;
        } else if (i < this.startIndex) {
            if ((i2 - i) + 1 > this.backing.length()) {
                return false;
            }
            this.startIndex = i;
        }
        this.backing.increment(toBufferIndex(i), j);
        return true;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public long get(int i) {
        if (i < this.startIndex || i > this.endIndex) {
            return 0L;
        }
        return this.backing.get(toBufferIndex(i));
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean isEmpty() {
        return this.baseIndex == Integer.MIN_VALUE;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getMaxSize() {
        return this.backing.length();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public void clear() {
        this.backing.clear();
        this.baseIndex = Integer.MIN_VALUE;
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
    }

    private int toBufferIndex(int i) {
        int i2 = i - this.baseIndex;
        if (i2 >= this.backing.length()) {
            return i2 - this.backing.length();
        }
        return i2 < 0 ? i2 + this.backing.length() : i2;
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder("{");
        for (int i2 = this.startIndex; i2 <= this.endIndex && (i = this.startIndex) != Integer.MIN_VALUE; i2++) {
            if (i2 != i) {
                sb.append(',');
            }
            sb.append(i2);
            sb.append('=');
            sb.append(get(i2));
        }
        sb.append("}");
        return sb.toString();
    }
}
