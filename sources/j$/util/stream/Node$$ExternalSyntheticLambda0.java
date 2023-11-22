package j$.util.stream;

import j$.util.DoubleSummaryStatistics;
import j$.util.IntSummaryStatistics;
import j$.util.LongSummaryStatistics;
import j$.util.Optional;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.OptionalLong;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleFunction;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntFunction;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongFunction;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.ObjIntConsumer;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class Node$$ExternalSyntheticLambda0 implements DoubleBinaryOperator, DoubleFunction, ObjDoubleConsumer, BiConsumer, Predicate, IntBinaryOperator, ObjIntConsumer, IntFunction, LongBinaryOperator, LongFunction, ObjLongConsumer, Consumer {
    public final /* synthetic */ int MyBillsEntityDataFactory;

    public /* synthetic */ Node$$ExternalSyntheticLambda0(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @Override // j$.util.function.LongBinaryOperator
    public final long BuiltInFictitiousFunctionClassFactory(long j, long j2) {
        int i = this.MyBillsEntityDataFactory;
        return i != 16 ? i != 17 ? j + j2 : Math.max(j, j2) : Math.min(j, j2);
    }

    @Override // j$.util.function.DoubleFunction
    public final Object BuiltInFictitiousFunctionClassFactory(double d) {
        return Double.valueOf(d);
    }

    @Override // j$.util.function.ObjIntConsumer
    public final void BuiltInFictitiousFunctionClassFactory(Object obj, int i) {
        ((IntSummaryStatistics) obj).accept(i);
    }

    @Override // j$.util.function.ObjLongConsumer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, long j) {
        ((LongSummaryStatistics) obj).accept(j);
    }

    @Override // j$.util.function.IntBinaryOperator
    public final int MyBillsEntityDataFactory(int i, int i2) {
        int i3 = this.MyBillsEntityDataFactory;
        return i3 != 10 ? i3 != 11 ? Math.max(i, i2) : i + i2 : Math.min(i, i2);
    }

    @Override // j$.util.function.IntFunction
    public final Object MyBillsEntityDataFactory(int i) {
        return Integer.valueOf(i);
    }

    @Override // j$.util.function.LongFunction
    public final Object MyBillsEntityDataFactory(long j) {
        return Long.valueOf(j);
    }

    @Override // j$.util.function.DoubleBinaryOperator
    public final double PlaceComponentResult(double d, double d2) {
        return this.MyBillsEntityDataFactory != 1 ? Math.max(d, d2) : Math.min(d, d2);
    }

    @Override // j$.util.function.ObjDoubleConsumer
    public final void PlaceComponentResult(Object obj, double d) {
        ((DoubleSummaryStatistics) obj).accept(d);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.MyBillsEntityDataFactory;
        if (i != 6 && i == 7) {
            return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
        }
        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return this.MyBillsEntityDataFactory != 5 ? BiConsumer.CC.getAuthRequestContext(this, biConsumer) : BiConsumer.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        int i = this.MyBillsEntityDataFactory;
        if (i != 6 && i != 7 && i == 8) {
            return Predicate.CC.PlaceComponentResult(this);
        }
        return Predicate.CC.PlaceComponentResult(this);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.MyBillsEntityDataFactory;
        if (i != 6 && i == 7) {
            return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
        }
        return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.MyBillsEntityDataFactory;
        return i != 6 ? i != 7 ? i != 8 ? ((OptionalInt) obj).PlaceComponentResult() : ((Optional) obj).KClassImpl$Data$declaredNonStaticMembers$2() : ((OptionalLong) obj).MyBillsEntityDataFactory() : ((OptionalDouble) obj).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.MyBillsEntityDataFactory;
        if (i != 5) {
            if (i == 13) {
                IntSummaryStatistics intSummaryStatistics = (IntSummaryStatistics) obj;
                IntSummaryStatistics intSummaryStatistics2 = (IntSummaryStatistics) obj2;
                intSummaryStatistics.KClassImpl$Data$declaredNonStaticMembers$2 += intSummaryStatistics2.KClassImpl$Data$declaredNonStaticMembers$2;
                intSummaryStatistics.MyBillsEntityDataFactory += intSummaryStatistics2.MyBillsEntityDataFactory;
                intSummaryStatistics.PlaceComponentResult = Math.min(intSummaryStatistics.PlaceComponentResult, intSummaryStatistics2.PlaceComponentResult);
                intSummaryStatistics.getAuthRequestContext = Math.max(intSummaryStatistics.getAuthRequestContext, intSummaryStatistics2.getAuthRequestContext);
                return;
            }
            LongSummaryStatistics longSummaryStatistics = (LongSummaryStatistics) obj;
            LongSummaryStatistics longSummaryStatistics2 = (LongSummaryStatistics) obj2;
            longSummaryStatistics.BuiltInFictitiousFunctionClassFactory += longSummaryStatistics2.BuiltInFictitiousFunctionClassFactory;
            longSummaryStatistics.getAuthRequestContext += longSummaryStatistics2.getAuthRequestContext;
            longSummaryStatistics.PlaceComponentResult = Math.min(longSummaryStatistics.PlaceComponentResult, longSummaryStatistics2.PlaceComponentResult);
            longSummaryStatistics.MyBillsEntityDataFactory = Math.max(longSummaryStatistics.MyBillsEntityDataFactory, longSummaryStatistics2.MyBillsEntityDataFactory);
            return;
        }
        DoubleSummaryStatistics doubleSummaryStatistics = (DoubleSummaryStatistics) obj;
        DoubleSummaryStatistics doubleSummaryStatistics2 = (DoubleSummaryStatistics) obj2;
        doubleSummaryStatistics.BuiltInFictitiousFunctionClassFactory += doubleSummaryStatistics2.BuiltInFictitiousFunctionClassFactory;
        doubleSummaryStatistics.MyBillsEntityDataFactory += doubleSummaryStatistics2.MyBillsEntityDataFactory;
        double d = doubleSummaryStatistics2.KClassImpl$Data$declaredNonStaticMembers$2 - doubleSummaryStatistics.lookAheadTest;
        double d2 = doubleSummaryStatistics.KClassImpl$Data$declaredNonStaticMembers$2;
        double d3 = d2 + d;
        double d4 = (d3 - d2) - d;
        doubleSummaryStatistics.lookAheadTest = d4;
        double d5 = doubleSummaryStatistics2.lookAheadTest - d4;
        double d6 = d3 + d5;
        doubleSummaryStatistics.lookAheadTest = (d6 - d3) - d5;
        doubleSummaryStatistics.KClassImpl$Data$declaredNonStaticMembers$2 = d6;
        doubleSummaryStatistics.PlaceComponentResult = Math.min(doubleSummaryStatistics.PlaceComponentResult, doubleSummaryStatistics2.PlaceComponentResult);
        doubleSummaryStatistics.getAuthRequestContext = Math.max(doubleSummaryStatistics.getAuthRequestContext, doubleSummaryStatistics2.getAuthRequestContext);
    }
}
