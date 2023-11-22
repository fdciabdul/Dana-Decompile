package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
public final /* synthetic */ class StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1 implements Sink.OfLong {
    public final /* synthetic */ int PlaceComponentResult;
    public final /* synthetic */ LongConsumer getAuthRequestContext;

    public /* synthetic */ StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1(LongConsumer longConsumer, int i) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = longConsumer;
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        int i = this.PlaceComponentResult;
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(int i) {
        int i2 = this.PlaceComponentResult;
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
    public final void accept(long j) {
        if (this.PlaceComponentResult != 0) {
            this.getAuthRequestContext.accept(j);
        } else {
            ((SpinedBuffer.OfLong) this.getAuthRequestContext).accept(j);
        }
    }

    @Override // j$.util.stream.Sink.OfLong
    public final /* synthetic */ void accept(Long l) {
        int i = this.PlaceComponentResult;
        Node.CC.PlaceComponentResult(this, l);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        int i = this.PlaceComponentResult;
        accept((Long) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.PlaceComponentResult;
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return this.PlaceComponentResult != 0 ? new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer) : new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
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
