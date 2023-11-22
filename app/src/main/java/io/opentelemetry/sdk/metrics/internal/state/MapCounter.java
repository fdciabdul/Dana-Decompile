package io.opentelemetry.sdk.metrics.internal.state;

import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes9.dex */
public class MapCounter implements ExponentialCounter {
    private static final int NULL_INDEX = Integer.MIN_VALUE;
    private final Map<Integer, AtomicLong> backing;
    private int indexEnd;
    private int indexStart;
    private final int maxSize;

    public MapCounter(int i) {
        this.maxSize = i;
        double d = i;
        Double.isNaN(d);
        this.backing = new ConcurrentHashMap(((int) Math.ceil(d / 0.75d)) + 1);
        this.indexEnd = Integer.MIN_VALUE;
        this.indexStart = Integer.MIN_VALUE;
    }

    public MapCounter(ExponentialCounter exponentialCounter) {
        int maxSize = exponentialCounter.getMaxSize();
        this.maxSize = maxSize;
        double d = maxSize;
        Double.isNaN(d);
        this.backing = new ConcurrentHashMap(((int) Math.ceil(d / 0.75d)) + 1);
        this.indexStart = exponentialCounter.getIndexStart();
        this.indexEnd = exponentialCounter.getIndexEnd();
        for (int i = this.indexStart; i <= this.indexEnd; i++) {
            long j = exponentialCounter.get(i);
            if (j != 0) {
                this.backing.put(Integer.valueOf(i), new AtomicLong(j));
            }
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexStart() {
        return this.indexStart;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexEnd() {
        return this.indexEnd;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean increment(int i, long j) {
        int i2 = this.indexStart;
        if (i2 == Integer.MIN_VALUE) {
            this.indexStart = i;
            this.indexEnd = i;
            doIncrement(i, j);
            return true;
        }
        int i3 = this.indexEnd;
        if (i > i3) {
            if ((i - i2) + 1 > this.maxSize) {
                return false;
            }
            this.indexEnd = i;
        } else if (i < i2) {
            if ((i3 - i) + 1 > this.maxSize) {
                return false;
            }
            this.indexStart = i;
        }
        doIncrement(i, j);
        return true;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public long get(int i) {
        AtomicLong atomicLong;
        if (i < this.indexStart || i > this.indexEnd || (atomicLong = this.backing.get(Integer.valueOf(i))) == null) {
            return 0L;
        }
        return atomicLong.longValue();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public void clear() {
        this.backing.clear();
        this.indexStart = Integer.MIN_VALUE;
        this.indexEnd = Integer.MIN_VALUE;
    }

    private void doIncrement(int i, long j) {
        synchronized (this) {
            if (((AtomicLong) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) this.backing, (Object) Integer.valueOf(i), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.MapCounter$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return MapCounter.lambda$doIncrement$0((Integer) obj);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            })).getAndAdd(j) + j == 0) {
                this.backing.remove(Integer.valueOf(i));
                if (isEmpty()) {
                    this.indexStart = Integer.MIN_VALUE;
                    this.indexEnd = Integer.MIN_VALUE;
                } else {
                    this.indexStart = ((Integer) Collections.min(this.backing.keySet())).intValue();
                    this.indexEnd = ((Integer) Collections.max(this.backing.keySet())).intValue();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AtomicLong lambda$doIncrement$0(Integer num) {
        return new AtomicLong(0L);
    }

    public String toString() {
        return this.backing.toString();
    }
}
