package kotlinx.coroutines.rx2;

import io.reactivex.CompletableEmitter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lkotlinx/coroutines/rx2/RxCompletableCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "(Lkotlin/Unit;)V", "Lio/reactivex/CompletableEmitter;", "subscriber", "Lio/reactivex/CompletableEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/CompletableEmitter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxCompletableCoroutine extends AbstractCoroutine<Unit> {
    private final CompletableEmitter subscriber;

    public RxCompletableCoroutine(CoroutineContext coroutineContext, CompletableEmitter completableEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = completableEmitter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Unit value) {
        try {
            this.subscriber.onComplete();
        } catch (Throwable th) {
            RxCancellableKt.handleUndeliverableException(th, get$context());
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable cause, boolean handled) {
        try {
            if (this.subscriber.tryOnError(cause)) {
                return;
            }
        } catch (Throwable th) {
            ExceptionsKt.addSuppressed(cause, th);
        }
        RxCancellableKt.handleUndeliverableException(cause, get$context());
    }
}
