package io.reactivex.rxkotlin;

import io.reactivex.functions.Function4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u000b\u0010\n\u001a\u00028\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u0000\"\b\b\u0004\u0010\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u0003H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "T1", "T2", "T3", "T4", "R", "p0", "p1", "p2", "p3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class Flowables$zip$5<T1, T2, T3, T4, R> implements Function4<T1, T2, T3, T4, R> {
    final /* synthetic */ kotlin.jvm.functions.Function4 $KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.functions.Function4
    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        Intrinsics.checkParameterIsNotNull(t3, "");
        Intrinsics.checkParameterIsNotNull(t4, "");
        return (R) this.$KClassImpl$Data$declaredNonStaticMembers$2.invoke(t1, t2, t3, t4);
    }
}
