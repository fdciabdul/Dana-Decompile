package j$.util.stream;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import j$.util.OptionalDouble;
import j$.util.function.Consumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes6.dex */
final class ReduceOps$12ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    final /* synthetic */ DoubleBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2;
    private double MyBillsEntityDataFactory;
    private boolean getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$12ReducingSink(DoubleBinaryOperator doubleBinaryOperator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleBinaryOperator;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$12ReducingSink reduceOps$12ReducingSink = (ReduceOps$12ReducingSink) reduceOps$AccumulatingSink;
        if (reduceOps$12ReducingSink.getAuthRequestContext) {
            return;
        }
        accept(reduceOps$12ReducingSink.MyBillsEntityDataFactory);
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
        } else {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory, d);
        }
        this.MyBillsEntityDataFactory = d;
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
        this.getAuthRequestContext = true;
        this.MyBillsEntityDataFactory = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
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
        return this.getAuthRequestContext ? OptionalDouble.PlaceComponentResult() : OptionalDouble.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
    }
}
