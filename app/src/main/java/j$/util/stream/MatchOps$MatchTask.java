package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Node;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
final class MatchOps$MatchTask extends AbstractShortCircuitTask {
    private final MatchOps$MatchOp op;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchOps$MatchTask(MatchOps$MatchOp matchOps$MatchOp, Node.CC cc, Spliterator spliterator) {
        super(cc, spliterator);
        this.op = matchOps$MatchOp;
    }

    MatchOps$MatchTask(MatchOps$MatchTask matchOps$MatchTask, Spliterator spliterator) {
        super(matchOps$MatchTask, spliterator);
        this.op = matchOps$MatchTask.op;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final Object doLeaf() {
        boolean z;
        Boolean valueOf;
        Node.CC cc = this.helper;
        MatchOps$BooleanTerminalSink matchOps$BooleanTerminalSink = (MatchOps$BooleanTerminalSink) this.op.PlaceComponentResult.get();
        cc.PlaceComponentResult(this.spliterator, matchOps$BooleanTerminalSink);
        boolean z2 = matchOps$BooleanTerminalSink.lookAheadTest;
        z = this.op.BuiltInFictitiousFunctionClassFactory.shortCircuitResult;
        if (z2 == z && (valueOf = Boolean.valueOf(z2)) != null) {
            AtomicReference atomicReference = this.sharedResult;
            while (!atomicReference.compareAndSet(null, valueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.AbstractShortCircuitTask
    protected final Object getEmptyResult() {
        boolean z;
        z = this.op.BuiltInFictitiousFunctionClassFactory.shortCircuitResult;
        return Boolean.valueOf(!z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // j$.util.stream.AbstractTask
    public final AbstractTask makeChild(Spliterator spliterator) {
        return new MatchOps$MatchTask(this, spliterator);
    }
}
