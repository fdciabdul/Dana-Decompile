package j$.util.stream;

import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntPredicate;
import j$.util.stream.Node;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class MatchOps$2MatchSink extends MatchOps$BooleanTerminalSink implements Sink.OfInt {
    final /* synthetic */ IntPredicate MyBillsEntityDataFactory;
    final /* synthetic */ MatchOps$MatchKind PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchOps$2MatchSink(IntPredicate intPredicate, MatchOps$MatchKind matchOps$MatchKind) {
        super(matchOps$MatchKind);
        this.PlaceComponentResult = matchOps$MatchKind;
        this.MyBillsEntityDataFactory = intPredicate;
    }

    @Override // j$.util.stream.MatchOps$BooleanTerminalSink, j$.util.stream.Sink
    public final void accept(int i) {
        boolean z;
        boolean z2;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = ((IntPredicate.VivifiedWrapper) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2(i);
        z = this.PlaceComponentResult.stopOnPredicateMatches;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            z2 = this.PlaceComponentResult.shortCircuitResult;
            this.lookAheadTest = z2;
        }
    }

    @Override // j$.util.stream.Sink.OfInt
    public final /* synthetic */ void accept(Integer num) {
        Node.CC.MyBillsEntityDataFactory(this, num);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ void accept(Object obj) {
        accept((Integer) obj);
    }

    @Override // j$.util.function.IntConsumer
    public final IntConsumer andThen(IntConsumer intConsumer) {
        return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
    }
}
