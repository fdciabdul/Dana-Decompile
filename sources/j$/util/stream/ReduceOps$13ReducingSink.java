package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.Supplier;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class ReduceOps$13ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    final /* synthetic */ BinaryOperator BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ ObjDoubleConsumer KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Supplier getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$13ReducingSink(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BinaryOperator binaryOperator) {
        this.getAuthRequestContext = supplier;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = objDoubleConsumer;
        this.BuiltInFictitiousFunctionClassFactory = binaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory.apply(this.NetworkUserEntityData$$ExternalSyntheticLambda0, ((ReduceOps$13ReducingSink) reduceOps$AccumulatingSink).NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, d);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(int i) {
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(long j) {
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfDouble
    public final /* synthetic */ void accept(Double d) {
        Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Double) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getAuthRequestContext.get();
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
