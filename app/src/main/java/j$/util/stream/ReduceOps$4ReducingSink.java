package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.Node;

/* loaded from: classes.dex */
final class ReduceOps$4ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink {
    final /* synthetic */ BiConsumer BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ Supplier PlaceComponentResult;
    final /* synthetic */ BiConsumer getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$4ReducingSink(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.PlaceComponentResult = supplier;
        this.BuiltInFictitiousFunctionClassFactory = biConsumer;
        this.getAuthRequestContext = biConsumer2;
    }

    @Override // j$.util.stream.ReduceOps$AccumulatingSink
    public final void MyBillsEntityDataFactory(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.getAuthRequestContext.accept(this.NetworkUserEntityData$$ExternalSyntheticLambda0, ((ReduceOps$4ReducingSink) reduceOps$AccumulatingSink).NetworkUserEntityData$$ExternalSyntheticLambda0);
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
    public final /* synthetic */ void accept(long j) {
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.BuiltInFictitiousFunctionClassFactory.accept(this.NetworkUserEntityData$$ExternalSyntheticLambda0, obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.PlaceComponentResult.get();
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
