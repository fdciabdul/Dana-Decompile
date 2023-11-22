package zipkin2.internal;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class DelayLimiter<C> {

    /* loaded from: classes9.dex */
    public static final class Builder {
        long MyBillsEntityDataFactory = 0;
        TimeUnit BuiltInFictitiousFunctionClassFactory = TimeUnit.MILLISECONDS;
        int PlaceComponentResult = 0;

        Builder() {
        }
    }

    /* loaded from: classes9.dex */
    static class SuppressionFactory {
        static long getAuthRequestContext() {
            return System.nanoTime();
        }
    }

    /* loaded from: classes9.dex */
    static final class Suppression<C> implements Delayed {
        final SuppressionFactory BuiltInFictitiousFunctionClassFactory;
        final long MyBillsEntityDataFactory;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Delayed delayed) {
            return Long.signum(this.MyBillsEntityDataFactory - ((Suppression) delayed).MyBillsEntityDataFactory);
        }

        @Override // java.util.concurrent.Delayed
        public final long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.MyBillsEntityDataFactory - SuppressionFactory.getAuthRequestContext(), TimeUnit.NANOSECONDS);
        }
    }
}
