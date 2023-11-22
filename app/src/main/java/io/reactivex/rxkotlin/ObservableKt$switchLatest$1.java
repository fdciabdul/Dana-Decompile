package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lio/reactivex/Observable;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
final class ObservableKt$switchLatest$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ObservableKt$switchLatest$1 getAuthRequestContext = new ObservableKt$switchLatest$1();

    ObservableKt$switchLatest$1() {
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final Observable<T> apply(Observable<T> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "");
        return observable;
    }
}
