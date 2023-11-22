package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "R", "p0", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class ObservableKt$flatMapSequence$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ Function1 $BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.functions.Function
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Observable<R> apply(T t) {
        Intrinsics.checkParameterIsNotNull(t, "");
        return ObservableKt.PlaceComponentResult((Sequence) this.$BuiltInFictitiousFunctionClassFactory.invoke(t));
    }
}
