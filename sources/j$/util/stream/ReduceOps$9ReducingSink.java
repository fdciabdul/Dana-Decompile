package j$.util.stream;

import j$.util.OptionalLong;
import j$.util.function.Consumer;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$9ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfLong {
    final /* synthetic */ LongBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2;
    private long PlaceComponentResult;
    private boolean getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$9ReducingSink(LongBinaryOperator longBinaryOperator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = longBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$9ReducingSink reduceOps$9ReducingSink = (ReduceOps$9ReducingSink) reduceOps$AccumulatingSink;
        if (reduceOps$9ReducingSink.getAuthRequestContext) {
            return;
        }
        accept(reduceOps$9ReducingSink.PlaceComponentResult);
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
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
        } else {
            j = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, j);
        }
        this.PlaceComponentResult = j;
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
        this.getAuthRequestContext = true;
        this.PlaceComponentResult = 0L;
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
        OptionalLong optionalLong;
        if (this.getAuthRequestContext) {
            optionalLong = OptionalLong.MyBillsEntityDataFactory;
            return optionalLong;
        }
        return OptionalLong.PlaceComponentResult(this.PlaceComponentResult);
    }
}
