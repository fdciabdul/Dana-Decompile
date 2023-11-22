package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T1", "T2", "p0", "p1", "Lkotlin/Pair;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class Flowables$combineLatest$2<T1, T2, R> implements BiFunction<T1, T2, Pair<? extends T1, ? extends T2>> {
    public static final Flowables$combineLatest$2 PlaceComponentResult = new Flowables$combineLatest$2();

    Flowables$combineLatest$2() {
    }

    @Override // io.reactivex.functions.BiFunction
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final Pair<T1, T2> apply(T1 t1, T2 t2) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        return TuplesKt.to(t1, t2);
    }
}
