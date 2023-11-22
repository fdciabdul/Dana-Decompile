package j$.util.stream;

import j$.util.function.IntBinaryOperator;

/* loaded from: classes2.dex */
final class ReduceOps$5 extends Nodes {
    final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ IntBinaryOperator MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReduceOps$5(IntBinaryOperator intBinaryOperator, int i) {
        this.MyBillsEntityDataFactory = intBinaryOperator;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // j$.util.stream.Nodes
    public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
        return new ReduceOps$5ReducingSink(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }
}
