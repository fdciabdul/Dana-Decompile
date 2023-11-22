package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class LongUnaryOperator$$ExternalSyntheticLambda1 implements LongUnaryOperator {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ LongUnaryOperator MyBillsEntityDataFactory;
    public final /* synthetic */ LongUnaryOperator PlaceComponentResult;

    public /* synthetic */ LongUnaryOperator$$ExternalSyntheticLambda1(LongUnaryOperator longUnaryOperator, LongUnaryOperator longUnaryOperator2, int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = longUnaryOperator;
        this.PlaceComponentResult = longUnaryOperator2;
    }

    @Override // j$.util.function.LongUnaryOperator
    public final LongUnaryOperator BuiltInFictitiousFunctionClassFactory(LongUnaryOperator longUnaryOperator) {
        int i = 1;
        return this.BuiltInFictitiousFunctionClassFactory != 0 ? new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, i) : new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, i);
    }

    @Override // j$.util.function.LongUnaryOperator
    public final LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2(LongUnaryOperator longUnaryOperator) {
        int i = 0;
        return this.BuiltInFictitiousFunctionClassFactory != 0 ? new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, i) : new LongUnaryOperator$$ExternalSyntheticLambda1(this, longUnaryOperator, i);
    }

    @Override // j$.util.function.LongUnaryOperator
    public final long getAuthRequestContext(long j) {
        if (this.BuiltInFictitiousFunctionClassFactory != 0) {
            return this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.getAuthRequestContext(j));
        }
        return this.PlaceComponentResult.getAuthRequestContext(this.MyBillsEntityDataFactory.getAuthRequestContext(j));
    }
}
