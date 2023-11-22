package j$.util.stream;

import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongPredicate;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class MatchOps$3MatchSink extends MatchOps$BooleanTerminalSink implements Sink.OfLong {
    final /* synthetic */ LongPredicate BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ MatchOps$MatchKind PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchOps$3MatchSink(LongPredicate longPredicate, MatchOps$MatchKind matchOps$MatchKind) {
        super(matchOps$MatchKind);
        this.PlaceComponentResult = matchOps$MatchKind;
        this.BuiltInFictitiousFunctionClassFactory = longPredicate;
    }

    @Override // j$.util.stream.MatchOps$BooleanTerminalSink, j$.util.stream.Sink
    public final void accept(long j) {
        boolean z;
        boolean z2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        boolean BuiltInFictitiousFunctionClassFactory = ((LongPredicate.VivifiedWrapper) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(j);
        z = this.PlaceComponentResult.stopOnPredicateMatches;
        if (BuiltInFictitiousFunctionClassFactory == z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            z2 = this.PlaceComponentResult.shortCircuitResult;
            this.lookAheadTest = z2;
        }
    }

    @Override // j$.util.stream.Sink.OfLong
    public final /* synthetic */ void accept(Long l) {
        Node.CC.PlaceComponentResult(this, l);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Long) obj);
    }

    @Override // j$.util.function.LongConsumer
    public final LongConsumer andThen(LongConsumer longConsumer) {
        return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
    }
}
