package androidx.window.embedding;

import android.view.WindowMetrics;
import j$.util.function.Predicate;

/* loaded from: classes6.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ SplitRule MyBillsEntityDataFactory;

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
        boolean PlaceComponentResult;
        PlaceComponentResult = EmbeddingAdapter.PlaceComponentResult(this.MyBillsEntityDataFactory, (WindowMetrics) obj);
        return PlaceComponentResult;
    }
}
