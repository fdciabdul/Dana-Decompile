package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes6.dex */
public final /* synthetic */ class Function$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Function BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ Function KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int MyBillsEntityDataFactory;

    public /* synthetic */ Function$$ExternalSyntheticLambda0(Function function, Function function2, int i) {
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = function;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
    }

    @Override // j$.util.function.Function
    /* renamed from: andThen */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        int i = this.MyBillsEntityDataFactory;
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        if (this.MyBillsEntityDataFactory != 0) {
            return this.BuiltInFictitiousFunctionClassFactory.apply(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(obj));
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.apply(this.BuiltInFictitiousFunctionClassFactory.apply(obj));
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        int i = this.MyBillsEntityDataFactory;
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }
}
