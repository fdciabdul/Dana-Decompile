package j$.util.stream;

import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda5 implements DoubleConsumer {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ Sink KClassImpl$Data$declaredNonStaticMembers$2;

    public /* synthetic */ DoublePipeline$$ExternalSyntheticLambda5(int i, Sink sink) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sink;
    }

    @Override // j$.util.function.DoubleConsumer
    public final void accept(double d) {
        (this.BuiltInFictitiousFunctionClassFactory != 0 ? ((DoublePipeline$1$1) this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory : this.KClassImpl$Data$declaredNonStaticMembers$2).accept(d);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return this.BuiltInFictitiousFunctionClassFactory != 0 ? new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer) : new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }
}
