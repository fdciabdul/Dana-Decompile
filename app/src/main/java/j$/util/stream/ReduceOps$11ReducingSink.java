package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$11ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    final /* synthetic */ DoubleBinaryOperator MyBillsEntityDataFactory;
    final /* synthetic */ double PlaceComponentResult;
    private double getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$11ReducingSink(double d, DoubleBinaryOperator doubleBinaryOperator) {
        this.PlaceComponentResult = d;
        this.MyBillsEntityDataFactory = doubleBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        accept(((ReduceOps$11ReducingSink) reduceOps$AccumulatingSink).getAuthRequestContext);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        this.getAuthRequestContext = this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext, d);
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
        this.getAuthRequestContext = this.PlaceComponentResult;
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
        return Double.valueOf(this.getAuthRequestContext);
    }
}
