package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import j$.util.stream.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MatchOps$MatchOp implements TerminalOp {
    final MatchOps$MatchKind BuiltInFictitiousFunctionClassFactory;
    final Supplier PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchOps$MatchOp(MatchOps$MatchKind matchOps$MatchKind, MatchOps$$ExternalSyntheticLambda0 matchOps$$ExternalSyntheticLambda0) {
        this.BuiltInFictitiousFunctionClassFactory = matchOps$MatchKind;
        this.PlaceComponentResult = matchOps$$ExternalSyntheticLambda0;
    }

    @Override // j$.util.stream.TerminalOp
    public final int BuiltInFictitiousFunctionClassFactory() {
        return StreamOpFlag.IS_SHORT_CIRCUIT | StreamOpFlag.NOT_ORDERED;
    }

    @Override // j$.util.stream.TerminalOp
    public final Object MyBillsEntityDataFactory(Node.CC cc, Spliterator spliterator) {
        MatchOps$BooleanTerminalSink matchOps$BooleanTerminalSink = (MatchOps$BooleanTerminalSink) this.PlaceComponentResult.get();
        cc.PlaceComponentResult(spliterator, matchOps$BooleanTerminalSink);
        return Boolean.valueOf(matchOps$BooleanTerminalSink.lookAheadTest);
    }

    @Override // j$.util.stream.TerminalOp
    public final Object getAuthRequestContext(Node.CC cc, Spliterator spliterator) {
        return (Boolean) new MatchOps$MatchTask(this, cc, spliterator).invoke();
    }
}
