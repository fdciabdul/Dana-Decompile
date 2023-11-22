package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.stream.Node;

/* loaded from: classes.dex */
public final /* synthetic */ class StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0 implements Sink {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ Consumer getAuthRequestContext;

    public /* synthetic */ StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0(Consumer consumer, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = consumer;
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(int i) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void accept(long j) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            this.getAuthRequestContext.accept(obj);
        } else {
            ((SpinedBuffer) this.getAuthRequestContext).accept(obj);
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return Consumer.CC.PlaceComponentResult(this, consumer);
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
