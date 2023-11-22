package io.reactivex.rxkotlin;

import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\t\u0010\b\u001a\u00028\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "T1", "T2", "T3", "R", "p0", "p1", "p2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class Observables$combineLatest$3<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {
    final /* synthetic */ kotlin.jvm.functions.Function3 $BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.functions.Function3
    public final R apply(T1 t1, T2 t2, T3 t3) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        Intrinsics.checkParameterIsNotNull(t3, "");
        return (R) this.$BuiltInFictitiousFunctionClassFactory.invoke(t1, t2, t3);
    }
}
