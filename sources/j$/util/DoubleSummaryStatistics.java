package j$.util;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final class DoubleSummaryStatistics implements DoubleConsumer {
    public long BuiltInFictitiousFunctionClassFactory;
    public double KClassImpl$Data$declaredNonStaticMembers$2;
    public double MyBillsEntityDataFactory;
    public double PlaceComponentResult = Double.POSITIVE_INFINITY;
    public double getAuthRequestContext = Double.NEGATIVE_INFINITY;
    public double lookAheadTest;

    @Override // j$.util.function.DoubleConsumer
    public final void accept(double d) {
        this.BuiltInFictitiousFunctionClassFactory++;
        this.MyBillsEntityDataFactory += d;
        double d2 = d - this.lookAheadTest;
        double d3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        double d4 = d3 + d2;
        this.lookAheadTest = (d4 - d3) - d2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d4;
        this.PlaceComponentResult = Math.min(this.PlaceComponentResult, d);
        this.getAuthRequestContext = Math.max(this.getAuthRequestContext, d);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }

    public final String toString() {
        double d;
        Object[] objArr = new Object[6];
        objArr[0] = DoubleSummaryStatistics.class.getSimpleName();
        objArr[1] = Long.valueOf(this.BuiltInFictitiousFunctionClassFactory);
        double d2 = this.KClassImpl$Data$declaredNonStaticMembers$2 + this.lookAheadTest;
        if (Double.isNaN(d2) && Double.isInfinite(this.MyBillsEntityDataFactory)) {
            d2 = this.MyBillsEntityDataFactory;
        }
        objArr[2] = Double.valueOf(d2);
        objArr[3] = Double.valueOf(this.PlaceComponentResult);
        if (this.BuiltInFictitiousFunctionClassFactory > 0) {
            double d3 = this.KClassImpl$Data$declaredNonStaticMembers$2 + this.lookAheadTest;
            if (Double.isNaN(d3) && Double.isInfinite(this.MyBillsEntityDataFactory)) {
                d3 = this.MyBillsEntityDataFactory;
            }
            double d4 = this.BuiltInFictitiousFunctionClassFactory;
            Double.isNaN(d4);
            d = d3 / d4;
        } else {
            d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        objArr[4] = Double.valueOf(d);
        objArr[5] = Double.valueOf(this.getAuthRequestContext);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
