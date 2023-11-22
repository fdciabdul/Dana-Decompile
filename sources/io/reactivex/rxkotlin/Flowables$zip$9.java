package io.reactivex.rxkotlin;

import io.reactivex.functions.Function8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0013\u0010\u0012\u001a\u00028\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u0000\"\b\b\u0004\u0010\u0005*\u00020\u0000\"\b\b\u0005\u0010\u0006*\u00020\u0000\"\b\b\u0006\u0010\u0007*\u00020\u0000\"\b\b\u0007\u0010\b*\u00020\u0000\"\b\b\b\u0010\t*\u00020\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u00022\u0006\u0010\r\u001a\u00028\u00032\u0006\u0010\u000e\u001a\u00028\u00042\u0006\u0010\u000f\u001a\u00028\u00052\u0006\u0010\u0010\u001a\u00028\u00062\u0006\u0010\u0011\u001a\u00028\u0007H\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "R", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class Flowables$zip$9<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
    final /* synthetic */ kotlin.jvm.functions.Function8 $BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.functions.Function8
    public final R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        Intrinsics.checkParameterIsNotNull(t1, "");
        Intrinsics.checkParameterIsNotNull(t2, "");
        Intrinsics.checkParameterIsNotNull(t3, "");
        Intrinsics.checkParameterIsNotNull(t4, "");
        Intrinsics.checkParameterIsNotNull(t5, "");
        Intrinsics.checkParameterIsNotNull(t6, "");
        Intrinsics.checkParameterIsNotNull(t7, "");
        Intrinsics.checkParameterIsNotNull(t8, "");
        return (R) this.$BuiltInFictitiousFunctionClassFactory.invoke(t1, t2, t3, t4, t5, t6, t7, t8);
    }
}
