package j$.util.stream;

import j$.util.OptionalInt;
import j$.util.function.Consumer;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$6ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfInt {
    private int BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ IntBinaryOperator PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$6ReducingSink(IntBinaryOperator intBinaryOperator) {
        this.PlaceComponentResult = intBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$6ReducingSink reduceOps$6ReducingSink = (ReduceOps$6ReducingSink) reduceOps$AccumulatingSink;
        if (reduceOps$6ReducingSink.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        accept(reduceOps$6ReducingSink.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final void accept(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        } else {
            i = this.PlaceComponentResult.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, i);
        }
        this.BuiltInFictitiousFunctionClassFactory = i;
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.BuiltInFictitiousFunctionClassFactory = 0;
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
        OptionalInt optionalInt;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            optionalInt = OptionalInt.getAuthRequestContext;
            return optionalInt;
        }
        return OptionalInt.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
    }
}
