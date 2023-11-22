package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
public final /* synthetic */ class StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda0 implements Sink.OfInt {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ IntConsumer getAuthRequestContext;

    public /* synthetic */ StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda0(IntConsumer intConsumer, int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.getAuthRequestContext = intConsumer;
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
    public final void accept(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory != 0) {
            this.getAuthRequestContext.accept(i);
        } else {
            ((SpinedBuffer.OfInt) this.getAuthRequestContext).accept(i);
        }
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(long j) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfInt
    public final /* synthetic */ void accept(Integer num) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        Node.CC.MyBillsEntityDataFactory(this, num);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        accept((Integer) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return this.BuiltInFictitiousFunctionClassFactory != 0 ? new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer) : new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void begin(long j) {
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
