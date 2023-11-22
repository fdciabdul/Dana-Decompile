package kotlinx.coroutines.rx2;

import io.reactivex.MaybeEmitter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxMaybeKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rxMaybeInternal$lambda-1  reason: not valid java name */
    public static final void m4675rxMaybeInternal$lambda1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, MaybeEmitter maybeEmitter) {
        RxMaybeCoroutine rxMaybeCoroutine = new RxMaybeCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), maybeEmitter);
        maybeEmitter.setCancellable(new RxCancellable(rxMaybeCoroutine));
        rxMaybeCoroutine.start(CoroutineStart.DEFAULT, rxMaybeCoroutine, function2);
    }
}
