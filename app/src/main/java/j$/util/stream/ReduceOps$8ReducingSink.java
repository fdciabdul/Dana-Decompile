package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$8ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfLong {
    final /* synthetic */ long BuiltInFictitiousFunctionClassFactory;
    private long MyBillsEntityDataFactory;
    final /* synthetic */ LongBinaryOperator PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$8ReducingSink(long j, LongBinaryOperator longBinaryOperator) {
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.PlaceComponentResult = longBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        accept(((ReduceOps$8ReducingSink) reduceOps$AccumulatingSink).MyBillsEntityDataFactory);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(int i) {
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final void accept(long j) {
        this.MyBillsEntityDataFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, j);
    }

    @Override // j$.util.stream.Sink.OfLong
    public final /* synthetic */ void accept(Long l) {
        Node.CC.PlaceComponentResult(this, l);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
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
        return Long.valueOf(this.MyBillsEntityDataFactory);
    }
}
