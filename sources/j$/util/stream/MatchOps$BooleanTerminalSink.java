package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.stream.Node;

/* loaded from: classes.dex */
abstract class MatchOps$BooleanTerminalSink implements Sink {
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    boolean lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchOps$BooleanTerminalSink(MatchOps$MatchKind matchOps$MatchKind) {
        boolean z;
        z = matchOps$MatchKind.shortCircuitResult;
        this.lookAheadTest = !z;
    }

    @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d) {
        Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public /* synthetic */ void accept(int i) {
        Node.CC.C();
        throw null;
    }

    @Override // j$.util.stream.Sink
    public /* synthetic */ void accept(long j) {
        Node.CC.A();
        throw null;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void begin(long j) {
    }

    @Override // j$.util.stream.Sink
    public final boolean cancellationRequested() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // j$.util.stream.Sink
    public final /* synthetic */ void end() {
    }
}
