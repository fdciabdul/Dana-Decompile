package id.dana.lib.gcontainer.extension;

import com.alibaba.ariver.kernel.RVEvents;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u001aO\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "Lio/reactivex/Observable;", "Lkotlin/Function1;", "", "onSuccess", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "subscribeWithAutoDispose", "(Lio/reactivex/Observable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class RxJavaExtKt {
    public static final <T> void subscribeWithAutoDispose(Observable<T> observable, final Function1<? super T, Unit> function1, final Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(observable, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        observable.subscribe(new DisposableObserver<T>() { // from class: id.dana.lib.gcontainer.extension.RxJavaExtKt$subscribeWithAutoDispose$1
            @Override // io.reactivex.Observer
            public final void onComplete() {
                dispose();
            }

            @Override // io.reactivex.Observer
            public final void onNext(T t) {
                function1.invoke(t);
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "");
                function12.invoke(e);
                dispose();
            }
        });
    }
}
