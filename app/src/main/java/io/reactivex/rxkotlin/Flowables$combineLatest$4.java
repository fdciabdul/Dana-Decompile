package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "T1", "T2", "T3", "p0", "p1", "p2", "Lkotlin/Triple;", "getAuthRequestContext", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
final class Flowables$combineLatest$4<T1, T2, T3, R> implements Function3<T1, T2, T3, Triple<? extends T1, ? extends T2, ? extends T3>> {
    public static final Flowables$combineLatest$4 PlaceComponentResult = new Flowables$combineLatest$4();

    Flowables$combineLatest$4() {
    }

    @Override // io.reactivex.functions.Function3
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public final Triple<T1, T2, T3> apply(T1 t1, T2 t2, T3 t3) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        Intrinsics.checkParameterIsNotNull(t3, "");
        return new Triple<>(t1, t2, t3);
    }
}
