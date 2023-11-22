package j$.util.stream;

import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleFunction;
import j$.util.function.DoublePredicate;
import j$.util.function.DoubleToIntFunction;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.DoubleUnaryOperator;
import j$.util.stream.IntPipeline;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class DoublePipeline$1$1 extends Sink.ChainedDouble {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ AbstractPipeline PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DoublePipeline$1$1(AbstractPipeline abstractPipeline, Sink sink, int i) {
        super(sink);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = abstractPipeline;
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 4) {
            this.MyBillsEntityDataFactory.begin(-1L);
        } else if (i != 5) {
            this.MyBillsEntityDataFactory.begin(j);
        } else {
            this.MyBillsEntityDataFactory.begin(-1L);
        }
    }

    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            this.MyBillsEntityDataFactory.accept(((DoubleUnaryOperator.VivifiedWrapper) ((DoubleUnaryOperator) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue)).getAuthRequestContext.applyAsDouble(d));
            return;
        }
        int i2 = 1;
        if (i == 1) {
            this.MyBillsEntityDataFactory.accept((Sink) ((DoubleFunction) ((IntPipeline.AnonymousClass4) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).BuiltInFictitiousFunctionClassFactory(d));
        } else if (i == 2) {
            this.MyBillsEntityDataFactory.accept(((DoubleToIntFunction.VivifiedWrapper) ((DoubleToIntFunction) ((IntPipeline.AnonymousClass3) this.PlaceComponentResult).scheduleImpl)).PlaceComponentResult.applyAsInt(d));
        } else if (i == 3) {
            this.MyBillsEntityDataFactory.accept(((DoubleToLongFunction) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(d));
        } else if (i != 4) {
            if (i != 5) {
                ((DoubleConsumer) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue).accept(d);
                this.MyBillsEntityDataFactory.accept(d);
            } else if (((DoublePredicate.VivifiedWrapper) ((DoublePredicate) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue)).MyBillsEntityDataFactory(d)) {
                this.MyBillsEntityDataFactory.accept(d);
            }
        } else {
            DoubleStream doubleStream = (DoubleStream) ((DoubleFunction) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue).BuiltInFictitiousFunctionClassFactory(d);
            if (doubleStream != null) {
                try {
                    doubleStream.getCallingPid().PlaceComponentResult(new DoublePipeline$$ExternalSyntheticLambda5(i2, this));
                } catch (Throwable th) {
                    try {
                        doubleStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (doubleStream != null) {
                doubleStream.close();
            }
        }
    }
}
