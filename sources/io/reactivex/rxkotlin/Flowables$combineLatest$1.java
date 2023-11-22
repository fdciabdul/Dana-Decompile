package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0006\u001a\u00028\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T1", "T2", "R", "p0", "p1", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class Flowables$combineLatest$1<T1, T2, R> implements BiFunction<T1, T2, R> {
    final /* synthetic */ Function2 $PlaceComponentResult;

    @Override // io.reactivex.functions.BiFunction
    public final R apply(T1 t1, T2 t2) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        return (R) this.$PlaceComponentResult.invoke(t1, t2);
    }
}
