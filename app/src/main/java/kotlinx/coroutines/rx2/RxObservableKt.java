package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxObservableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rxObservableInternal$lambda-1  reason: not valid java name */
    public static final void m4676rxObservableInternal$lambda1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, ObservableEmitter observableEmitter) {
        RxObservableCoroutine rxObservableCoroutine = new RxObservableCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), observableEmitter);
        observableEmitter.setCancellable(new RxCancellable(rxObservableCoroutine));
        rxObservableCoroutine.start(CoroutineStart.DEFAULT, rxObservableCoroutine, function2);
    }
}
