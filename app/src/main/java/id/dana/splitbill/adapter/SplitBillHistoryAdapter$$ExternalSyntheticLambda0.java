package id.dana.splitbill.adapter;

import id.dana.domain.splitbill.model.SplitBillHistory;
import j$.util.function.Predicate;
import java.util.Objects;

/* loaded from: classes5.dex */
public final /* synthetic */ class SplitBillHistoryAdapter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String MyBillsEntityDataFactory;

    public /* synthetic */ SplitBillHistoryAdapter$$ExternalSyntheticLambda0(String str) {
        this.MyBillsEntityDataFactory = str;
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
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
        boolean equals;
        equals = Objects.equals(((SplitBillHistory) obj).getStatus(), this.MyBillsEntityDataFactory);
        return equals;
    }
}
