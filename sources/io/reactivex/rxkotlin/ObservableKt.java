package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "T", "Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "getAuthRequestContext", "(Ljava/lang/Iterable;)Lio/reactivex/Observable;", "Lkotlin/sequences/Sequence;", "PlaceComponentResult", "(Lkotlin/sequences/Sequence;)Lio/reactivex/Observable;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class ObservableKt {
    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> PlaceComponentResult(Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "");
        Iterable asIterable = SequencesKt.asIterable(sequence);
        Intrinsics.checkParameterIsNotNull(asIterable, "");
        Observable<T> fromIterable = Observable.fromIterable(asIterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "");
        return fromIterable;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> getAuthRequestContext(Iterable<? extends Observable<? extends T>> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "");
        Intrinsics.checkParameterIsNotNull(iterable, "");
        Observable fromIterable = Observable.fromIterable(iterable);
        Intrinsics.checkExpressionValueIsNotNull(fromIterable, "");
        Observable<T> merge = Observable.merge(fromIterable);
        Intrinsics.checkExpressionValueIsNotNull(merge, "");
        return merge;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static final <T> Observable<T> BuiltInFictitiousFunctionClassFactory(Observable<? extends Iterable<? extends T>> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "");
        Observable<T> observable2 = (Observable<T>) observable.flatMapIterable(new Function<T, Iterable<? extends U>>() { // from class: io.reactivex.rxkotlin.ObservableKt$flatMapIterable$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.functions.Function
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
            public final Iterable<T> apply(Iterable<? extends T> iterable) {
                Intrinsics.checkParameterIsNotNull(iterable, "");
                return iterable;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(observable2, "");
        return observable2;
    }
}
