package io.opentelemetry.sdk.metrics.internal.aggregator;

import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.util.Map;

/* loaded from: classes3.dex */
class ExponentialHistogramIndexer {
    private static final int EXPONENT_BIAS = 1023;
    private static final long EXPONENT_BIT_MASK = 9218868437227405312L;
    private static final int EXPONENT_WIDTH = 11;
    private static final long SIGNIFICAND_BIT_MASK = 4503599627370495L;
    private static final int SIGNIFICAND_WIDTH = 52;
    private final int scale;
    private final double scaleFactor;
    private static final Map<Integer, ExponentialHistogramIndexer> cache = new ConcurrentHashMap();
    private static final double LOG_BASE2_E = 1.0d / Math.log(2.0d);

    private ExponentialHistogramIndexer(int i) {
        this.scale = i;
        this.scaleFactor = computeScaleFactor(i);
    }

    public static ExponentialHistogramIndexer get(final int i) {
        return (ExponentialHistogramIndexer) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) cache, (Object) Integer.valueOf(i), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramIndexer$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ExponentialHistogramIndexer.lambda$get$0(i, (Integer) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ExponentialHistogramIndexer lambda$get$0(int i, Integer num) {
        return new ExponentialHistogramIndexer(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeIndex(double d) {
        double abs = Math.abs(d);
        int i = this.scale;
        if (i > 0) {
            return getIndexByLogarithm(abs);
        }
        if (i == 0) {
            return mapToIndexScaleZero(abs);
        }
        return mapToIndexScaleZero(abs) >> (-this.scale);
    }

    private int getIndexByLogarithm(double d) {
        return ((int) Math.ceil(Math.log(d) * this.scaleFactor)) - 1;
    }

    private static int mapToIndexScaleZero(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        long j = (EXPONENT_BIT_MASK & doubleToLongBits) >> 52;
        long j2 = doubleToLongBits & SIGNIFICAND_BIT_MASK;
        if (j == 0) {
            j -= (long) ((Long.numberOfLeadingZeros(j2 - 1) - 11) - 1);
        }
        int i = (int) (j - 1023);
        return j2 == 0 ? i - 1 : i;
    }

    private static double computeScaleFactor(int i) {
        return Math.scalb(LOG_BASE2_E, i);
    }
}
