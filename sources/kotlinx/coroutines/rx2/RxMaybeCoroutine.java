package kotlinx.coroutines.rx2;

import io.reactivex.MaybeEmitter;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/rx2/RxMaybeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "cause", "", "handled", "", "onCancelled", "(Ljava/lang/Throwable;Z)V", "value", "onCompleted", "(Ljava/lang/Object;)V", "Lio/reactivex/MaybeEmitter;", "subscriber", "Lio/reactivex/MaybeEmitter;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/MaybeEmitter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RxMaybeCoroutine<T> extends AbstractCoroutine<T> {
    private final MaybeEmitter<T> subscriber;

    public RxMaybeCoroutine(CoroutineContext coroutineContext, MaybeEmitter<T> maybeEmitter) {
        super(coroutineContext, false, true);
        this.subscriber = maybeEmitter;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(T value) {
        try {
            if (value == null) {
                this.subscriber.onComplete();
            } else {
                this.subscriber.onSuccess(value);
            }
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
