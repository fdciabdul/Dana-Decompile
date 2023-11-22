package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class FindOps$FindOp implements TerminalOp {
    final Supplier BuiltInFictitiousFunctionClassFactory;
    final Predicate KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    final Object PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FindOps$FindOp(boolean z, Object obj, Node$$ExternalSyntheticLambda0 node$$ExternalSyntheticLambda0, FindOps$$ExternalSyntheticLambda1 findOps$$ExternalSyntheticLambda1) {
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = obj;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = node$$ExternalSyntheticLambda0;
        this.BuiltInFictitiousFunctionClassFactory = findOps$$ExternalSyntheticLambda1;
    }

    @Override // j$.util.stream.TerminalOp
    public final int BuiltInFictitiousFunctionClassFactory() {
        return StreamOpFlag.IS_SHORT_CIRCUIT | (this.MyBillsEntityDataFactory ? 0 : StreamOpFlag.NOT_ORDERED);
    }

    @Override // j$.util.stream.TerminalOp
    public final Object MyBillsEntityDataFactory(Node.CC cc, Spliterator spliterator) {
        TerminalSink terminalSink = (TerminalSink) this.BuiltInFictitiousFunctionClassFactory.get();
        cc.PlaceComponentResult(spliterator, terminalSink);
        Object obj = terminalSink.get();
        return obj == null ? this.PlaceComponentResult : obj;
    }

    @Override // j$.util.stream.TerminalOp
    public final Object getAuthRequestContext(Node.CC cc, Spliterator spliterator) {
        return new FindOps$FindTask(this, cc, spliterator).invoke();
    }
}
