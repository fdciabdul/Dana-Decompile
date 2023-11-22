package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.ObjIntConsumer;
import j$.util.function.Supplier;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class ReduceOps$7ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink, Sink.OfInt {
    final /* synthetic */ ObjIntConsumer BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ Supplier KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ BinaryOperator getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$7ReducingSink(Supplier supplier, ObjIntConsumer objIntConsumer, BinaryOperator binaryOperator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = supplier;
        this.BuiltInFictitiousFunctionClassFactory = objIntConsumer;
        this.getAuthRequestContext = binaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getAuthRequestContext.apply(this.NetworkUserEntityData$$ExternalSyntheticLambda0, ((ReduceOps$7ReducingSink) reduceOps$AccumulatingSink).NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final void accept(int i) {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(long j) {
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfInt
    public final /* synthetic */ void accept(Integer num) {
        Node.CC.MyBillsEntityDataFactory(this, num);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Integer) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
