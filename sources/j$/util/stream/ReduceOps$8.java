package j$.util.stream;

import j$.util.function.LongBinaryOperator;

/* loaded from: classes2.dex */
final class ReduceOps$8 extends Nodes {
    final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ LongBinaryOperator getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$8(LongBinaryOperator longBinaryOperator, long j) {
        this.getAuthRequestContext = longBinaryOperator;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // j$.util.stream.Nodes
    public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
        return new ReduceOps$8ReducingSink(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
    }
}
