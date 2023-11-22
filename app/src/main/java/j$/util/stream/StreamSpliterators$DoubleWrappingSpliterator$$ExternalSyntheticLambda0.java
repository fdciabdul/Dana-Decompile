package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
public final /* synthetic */ class StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda0 implements Sink.OfDouble {
    public final /* synthetic */ DoubleConsumer KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int PlaceComponentResult;

    public /* synthetic */ StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda0(DoubleConsumer doubleConsumer, int i) {
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleConsumer;
    }

    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        if (this.PlaceComponentResult != 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.accept(d);
        } else {
            ((SpinedBuffer.OfDouble) this.KClassImpl$Data$declaredNonStaticMembers$2).accept(d);
        }
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(int i) {
        int i2 = this.PlaceComponentResult;
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(long j) {
        int i = this.PlaceComponentResult;
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfDouble
    public final /* synthetic */ void accept(Double d) {
        int i = this.PlaceComponentResult;
        Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        int i = this.PlaceComponentResult;
        accept((Double) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.PlaceComponentResult;
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return this.PlaceComponentResult != 0 ? new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer) : new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
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
