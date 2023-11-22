package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlin/sequences/Sequence;", "Lio/reactivex/Flowable;", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/sequences/Sequence;)Lio/reactivex/Flowable;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class FlowableKt {
    public static final <T> Flowable<T> BuiltInFictitiousFunctionClassFactory(Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "");
        Iterable asIterable = SequencesKt.asIterable(sequence);
        Intrinsics.checkParameterIsNotNull(asIterable, "");
        Flowable<T> BuiltInFictitiousFunctionClassFactory = Flowable.BuiltInFictitiousFunctionClassFactory(asIterable);
        Intrinsics.checkExpressionValueIsNotNull(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }
}
