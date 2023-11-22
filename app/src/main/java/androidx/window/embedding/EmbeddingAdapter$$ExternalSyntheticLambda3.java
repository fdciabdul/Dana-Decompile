package androidx.window.embedding;

import android.content.Intent;
import j$.util.function.Predicate;
import java.util.Set;

/* loaded from: classes6.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ Set KClassImpl$Data$declaredNonStaticMembers$2;

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
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = EmbeddingAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, (Intent) obj);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
