package id.dana.domain.extension;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "Lio/reactivex/Observable;", "", "millis", "timeoutForFirstEmit", "(Lio/reactivex/Observable;J)Lio/reactivex/Observable;", "toSingleObservable", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ObservableExtKt {
    public static final <T> Observable<T> timeoutForFirstEmit(Observable<T> observable, long j) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> timeout = observable.timeout(Observable.timer(j, TimeUnit.MILLISECONDS), new Function() { // from class: id.dana.domain.extension.ObservableExtKt$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2320timeoutForFirstEmit$lambda0;
                m2320timeoutForFirstEmit$lambda0 = ObservableExtKt.m2320timeoutForFirstEmit$lambda0(obj);
                return m2320timeoutForFirstEmit$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(timeout, "");
        return timeout;
    }

    /* renamed from: timeoutForFirstEmit$lambda-0 */
    public static final ObservableSource m2320timeoutForFirstEmit$lambda0(Object obj) {
        return Observable.never();
    }

    public static final <T> Observable<T> toSingleObservable(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> take = observable.take(1L);
        Intrinsics.checkNotNullExpressionValue(take, "");
        return take;
    }
}
