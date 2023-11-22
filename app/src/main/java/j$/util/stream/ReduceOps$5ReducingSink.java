package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$5ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfInt {
    final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ IntBinaryOperator MyBillsEntityDataFactory;
    private int PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$5ReducingSink(int i, IntBinaryOperator intBinaryOperator) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = intBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        accept(((ReduceOps$5ReducingSink) reduceOps$AccumulatingSink).PlaceComponentResult);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final void accept(int i) {
        this.PlaceComponentResult = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult, i);
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
        this.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.PlaceComponentResult);
    }
}
