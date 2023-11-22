package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T, U] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "U", "p0", "p1", "Lkotlin/Pair;", "MyBillsEntityDataFactory", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class ObservablesKt$zipWith$2<T1, T2, R, T, U> implements BiFunction<T, U, Pair<? extends T, ? extends U>> {
    public static final ObservablesKt$zipWith$2 BuiltInFictitiousFunctionClassFactory = new ObservablesKt$zipWith$2();

    ObservablesKt$zipWith$2() {
    }

    @Override // io.reactivex.functions.BiFunction
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final Pair<T, U> apply(T t, U u) {
        Intrinsics.checkParameterIsNotNull(t, "");
        Intrinsics.checkParameterIsNotNull(u, "");
        return new Pair<>(t, u);
    }
}
