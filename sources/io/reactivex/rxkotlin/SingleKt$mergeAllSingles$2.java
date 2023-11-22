package io.reactivex.rxkotlin;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lio/reactivex/Single;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lio/reactivex/Single;)Lio/reactivex/Single;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class SingleKt$mergeAllSingles$2<T, R> implements Function<T, SingleSource<? extends R>> {
    public static final SingleKt$mergeAllSingles$2 BuiltInFictitiousFunctionClassFactory = new SingleKt$mergeAllSingles$2();

    SingleKt$mergeAllSingles$2() {
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Single<T> apply(Single<T> single) {
        Intrinsics.checkParameterIsNotNull(single, "");
        return single;
    }
}
