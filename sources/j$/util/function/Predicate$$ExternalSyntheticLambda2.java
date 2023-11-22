package j$.util.function;

import j$.util.function.Predicate;

/* loaded from: classes6.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ Predicate MyBillsEntityDataFactory;
    public final /* synthetic */ Predicate PlaceComponentResult;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda2(Predicate predicate, Predicate predicate2, int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.PlaceComponentResult = predicate;
        this.MyBillsEntityDataFactory = predicate2;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        return this.BuiltInFictitiousFunctionClassFactory != 0 ? Predicate.CC.PlaceComponentResult(this) : Predicate.CC.PlaceComponentResult(this);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        if (this.BuiltInFictitiousFunctionClassFactory != 0) {
            return this.PlaceComponentResult.test(obj) || this.MyBillsEntityDataFactory.test(obj);
        }
        return this.PlaceComponentResult.test(obj) && this.MyBillsEntityDataFactory.test(obj);
    }
}
