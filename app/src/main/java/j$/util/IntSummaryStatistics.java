package j$.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final class IntSummaryStatistics implements IntConsumer {
    public long KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public int PlaceComponentResult = Integer.MAX_VALUE;
    public int getAuthRequestContext = Integer.MIN_VALUE;

    @Override // j$.util.function.IntConsumer
    public final void accept(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
        this.MyBillsEntityDataFactory += i;
        this.PlaceComponentResult = Math.min(this.PlaceComponentResult, i);
        this.getAuthRequestContext = Math.max(this.getAuthRequestContext, i);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }

    public final String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = IntSummaryStatistics.class.getSimpleName();
        objArr[1] = Long.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2);
        objArr[2] = Long.valueOf(this.MyBillsEntityDataFactory);
        objArr[3] = Integer.valueOf(this.PlaceComponentResult);
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (j > 0) {
            double d2 = this.MyBillsEntityDataFactory;
            double d3 = j;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = d2 / d3;
        } else {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        objArr[4] = Double.valueOf(d);
        objArr[5] = Integer.valueOf(this.getAuthRequestContext);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
