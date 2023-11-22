package j$.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public final class LongSummaryStatistics implements LongConsumer, IntConsumer {
    public long BuiltInFictitiousFunctionClassFactory;
    public long getAuthRequestContext;
    public long PlaceComponentResult = LongCompanionObject.MAX_VALUE;
    public long MyBillsEntityDataFactory = Long.MIN_VALUE;

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
        accept(i);
    }

    @Override // j$.util.function.LongConsumer
    public final void accept(long j) {
        this.BuiltInFictitiousFunctionClassFactory++;
        this.getAuthRequestContext += j;
        this.PlaceComponentResult = Math.min(this.PlaceComponentResult, j);
        this.MyBillsEntityDataFactory = Math.max(this.MyBillsEntityDataFactory, j);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }

    public final String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = LongSummaryStatistics.class.getSimpleName();
        objArr[1] = Long.valueOf(this.BuiltInFictitiousFunctionClassFactory);
        objArr[2] = Long.valueOf(this.getAuthRequestContext);
        objArr[3] = Long.valueOf(this.PlaceComponentResult);
        long j = this.BuiltInFictitiousFunctionClassFactory;
        if (j > 0) {
            double d2 = this.getAuthRequestContext;
            double d3 = j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = d2 / d3;
        } else {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        objArr[4] = Double.valueOf(d);
        objArr[5] = Long.valueOf(this.MyBillsEntityDataFactory);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
