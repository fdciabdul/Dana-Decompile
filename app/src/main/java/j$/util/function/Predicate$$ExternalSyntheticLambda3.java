package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Predicate;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda3 implements BinaryOperator, Predicate {
    public final /* synthetic */ int MyBillsEntityDataFactory;
    public final /* synthetic */ Object getAuthRequestContext;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda3(int i, Object obj) {
        this.MyBillsEntityDataFactory = i;
        this.getAuthRequestContext = obj;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        int i = this.MyBillsEntityDataFactory;
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.MyBillsEntityDataFactory != 1 ? ((Comparator) this.getAuthRequestContext).compare(obj, obj2) > 0 ? obj2 : obj : ((Comparator) this.getAuthRequestContext).compare(obj, obj2) < 0 ? obj2 : obj;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        return Predicate.CC.PlaceComponentResult(this);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return !((Predicate) this.getAuthRequestContext).test(obj);
    }
}
