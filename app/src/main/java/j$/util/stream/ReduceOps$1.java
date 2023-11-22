package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.ObjIntConsumer;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ReduceOps$1 extends Nodes {
    final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int MyBillsEntityDataFactory;
    final /* synthetic */ Object PlaceComponentResult;
    final /* synthetic */ Object getAuthRequestContext;

    public /* synthetic */ ReduceOps$1(Object obj, Object obj2, Object obj3, int i) {
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
        this.getAuthRequestContext = obj2;
        this.PlaceComponentResult = obj3;
    }

    @Override // j$.util.stream.Nodes
    public final ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.MyBillsEntityDataFactory;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new ReduceOps$7ReducingSink((Supplier) this.PlaceComponentResult, (ObjIntConsumer) this.getAuthRequestContext, (BinaryOperator) this.KClassImpl$Data$declaredNonStaticMembers$2) : new ReduceOps$4ReducingSink((Supplier) this.PlaceComponentResult, (BiConsumer) this.getAuthRequestContext, (BiConsumer) this.KClassImpl$Data$declaredNonStaticMembers$2) : new ReduceOps$13ReducingSink((Supplier) this.PlaceComponentResult, (ObjDoubleConsumer) this.getAuthRequestContext, (BinaryOperator) this.KClassImpl$Data$declaredNonStaticMembers$2) : new ReduceOps$10ReducingSink((Supplier) this.PlaceComponentResult, (ObjLongConsumer) this.getAuthRequestContext, (BinaryOperator) this.KClassImpl$Data$declaredNonStaticMembers$2) : new ReduceOps$1ReducingSink(this.PlaceComponentResult, (BiFunction) this.getAuthRequestContext, (BinaryOperator) this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
