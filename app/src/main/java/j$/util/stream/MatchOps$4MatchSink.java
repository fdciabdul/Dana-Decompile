package j$.util.stream;

import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.DoublePredicate;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class MatchOps$4MatchSink extends MatchOps$BooleanTerminalSink implements Sink.OfDouble {
    final /* synthetic */ DoublePredicate MyBillsEntityDataFactory;
    final /* synthetic */ MatchOps$MatchKind PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchOps$4MatchSink(DoublePredicate doublePredicate, MatchOps$MatchKind matchOps$MatchKind) {
        super(matchOps$MatchKind);
        this.PlaceComponentResult = matchOps$MatchKind;
        this.MyBillsEntityDataFactory = doublePredicate;
    }

    @Override // j$.util.stream.MatchOps$BooleanTerminalSink, j$.util.stream.Sink, j$.util.function.DoubleConsumer
    public final void accept(double d) {
        boolean z;
        boolean z2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        boolean MyBillsEntityDataFactory = ((DoublePredicate.VivifiedWrapper) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory(d);
        z = this.PlaceComponentResult.stopOnPredicateMatches;
        if (MyBillsEntityDataFactory == z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            z2 = this.PlaceComponentResult.shortCircuitResult;
            this.lookAheadTest = z2;
        }
    }

    @Override // j$.util.stream.Sink.OfDouble
    public final /* synthetic */ void accept(Double d) {
        Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Double) obj);
    }

    @Override // j$.util.function.DoubleConsumer
    public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
    }
}
